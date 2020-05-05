package main

import (
	"database/sql"
	"log"
	"net/http"
	"regexp"
	"strings"
	"time"

	"github.com/gocolly/colly"
	_ "github.com/lib/pq"
)

const (
	port                 = "8080"
	fetchTimeToQuestions = time.Minute * 5
)

var (
	db        *sql.DB
	tick      = time.NewTicker(fetchTimeToQuestions)
	blacklist = make([]*Blacklist, 0)
	space     = regexp.MustCompile(`\s+`)
)

func main() {
	log.Println("Crawler server started at port: " + port)

	initDatabase()
	initFirebase()

	go crawlerAndNotify()

	mux := http.NewServeMux()
	mux.HandleFunc("/api/v1/register", registerClient)

	if err := http.ListenAndServe(":"+port, mux); err != nil {
		log.Fatalln("[main]", err)
	}
}

func initDatabase() {
	connStr := "postgres://octopus:octopus@db:5432/octopus?sslmode=disable"
	tdb, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Fatalln("[main.initDatabase]", err)
	}

	if err = tdb.Ping(); err != nil {
		log.Fatalln("[main.initDatabase]", err)
	}

	db = tdb
}

func crawlerAndNotify() {
	for range tick.C {
		blacklist = queryBlacklist()
		products := queryProducts()

		for _, p := range products {
			product := p
			relevantQuestions := make(chan []*Question)

			go buildRelevantQuestions(product.Link, product.ID, relevantQuestions)
			go notifyRelevantQuestions(<-relevantQuestions)
		}
	}
}

func buildRelevantQuestions(productLink string, productId int64, relevantQuestions chan<- []*Question) {
	questions := extractQuestionsFromLink(productLink)
	relevantQuestions <- filterQuestions(questions, productId)
}

func notifyRelevantQuestions(relevantQuestions []*Question) {
	for _, v := range relevantQuestions {
		q := v
		go pushNotification(q)
	}
}

func queryBlacklist() []*Blacklist {
	var blacklist = make([]*Blacklist, 0)

	rows, err := db.Query("SELECT id, text FROM blacklist")
	if err != nil {
		log.Println("[main.queryBlacklist]", err)
	}
	defer rows.Close()

	for rows.Next() {
		var bl Blacklist

		if err = rows.Scan(&bl.ID, &bl.Text); err != nil {
			log.Println("[main.queryBlacklist]", err)
			break
		}

		blacklist = append(blacklist, &bl)
	}

	return blacklist
}

func queryProducts() []*Product {
	var products = make([]*Product, 0)

	rows, err := db.Query("SELECT id, name, link FROM product")
	if err != nil {
		log.Println("[main.queryProducts]", err)
	}
	defer rows.Close()

	for rows.Next() {
		var p Product

		if err = rows.Scan(&p.ID, &p.Name, &p.Link); err != nil {
			log.Println("[main.queryProducts]", err)
			break
		}

		products = append(products, &p)
	}

	return products
}

func extractQuestionsFromLink(link string) []*Question {
	var questions = make([]*Question, 0)

	var c = colly.NewCollector()

	c.OnHTML(".questions__block", func(e *colly.HTMLElement) {
		e.ForEach(".questions__list > li", func(_ int, elem *colly.HTMLElement) {
			question := &Question{}
			question.Text = elem.ChildText(".questions__block > .questions__list > .questions__group > article:first-child > .questions__content > p")
			questions = append(questions, question)
		})
	})

	c.Visit(link)

	return questions
}

func filterQuestions(questions []*Question, productId int64) []*Question {
	var filteredQuestions = make([]*Question, 0)

	for _, question := range questions {
		var q = Question{
			Text:      space.ReplaceAllString(question.Text, " "),
			ProductID: productId,
		}

		db.QueryRow("SELECT id, is_notified, is_relevant FROM question WHERE text = $1", q.Text).Scan(&q.ID, &q.IsNotified, &q.IsRelevant)

		if q.ID != 0 {
			continue
		}

		if result := isRelevantQuestion(&q); result {
			q.IsRelevant = true
		}

		if err := saveQuestion(&q); err != nil {
			continue
		}

		if q.IsRelevant {
			filteredQuestions = append(filteredQuestions, &q)
		}
	}

	return filteredQuestions
}

func isRelevantQuestion(question *Question) bool {
	for _, b := range blacklist {
		textBlacklisted := space.ReplaceAllString(b.Text, " ")

		if strings.Contains(question.Text, textBlacklisted) {
			return false
		}
	}

	return true
}

func saveQuestion(question *Question) error {
	var id int64

	if err := db.QueryRow("INSERT INTO question(text, is_notified, is_relevant, product_id) VALUES($1, $2, $3, $4) RETURNING id", question.Text, question.IsNotified, question.IsRelevant, question.ProductID).Scan(&id); err != nil {
		log.Println("[main.saveQuestion]", err)
		return err
	}

	question.ID = id
	return nil
}

func updateQuestion(question *Question) error {
	_, err := db.Exec("UPDATE question SET is_notified = $1, is_relevant = $2", question.IsNotified, question.IsRelevant)
	if err != nil {
		log.Println("[main.updateQuestion]", err)
		return err
	}

	return nil
}
