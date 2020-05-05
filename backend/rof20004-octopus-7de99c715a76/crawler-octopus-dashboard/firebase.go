package main

import (
	"encoding/json"
	"io"
	"log"
	"net/http"

	"google.golang.org/api/option"

	"firebase.google.com/go/messaging"

	firebase "firebase.google.com/go"

	"golang.org/x/net/context"
)

const topic = "octopus_dashboard"

var app *firebase.App

type Registration struct {
	Token string `json:"token"`
}

func initFirebase() {
	opt := option.WithCredentialsFile("firebase.json")

	tmp, err := firebase.NewApp(context.Background(), nil, opt)
	if err != nil {
		log.Fatalln("[main.initFirebase]", err)
	}

	app = tmp
}

func registerClient(w http.ResponseWriter, r *http.Request) {
	if r.Method != http.MethodOptions && r.Method != http.MethodPost {
		w.WriteHeader(http.StatusNotFound)
		return
	}

	if r.Method == http.MethodOptions {
		w.Header().Set("Access-Control-Allow-Origin", "*")
		w.Header().Set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
		w.Header().Set("Access-Control-Allow-Headers", "Accept, Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization")
		w.WriteHeader(http.StatusOK)
		return
	}

	var registration Registration

	if err := json.NewDecoder(r.Body).Decode(&registration); err != nil {
		log.Println("[firebase.registerClient]", err)
		w.WriteHeader(http.StatusBadRequest)
		io.WriteString(w, "É obrigatório informar o token")
		return
	}

	client, err := app.Messaging(r.Context())
	if err != nil {
		log.Println("[main.registerClient]", err)
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	response, err := client.SubscribeToTopic(r.Context(), []string{registration.Token}, topic)
	if err != nil {
		log.Println("[main.registerClient]", err)
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	if response.SuccessCount == 0 {
		for _, v := range response.Errors {
			log.Println("[main.registerClient]", v.Reason)
		}
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	w.WriteHeader(http.StatusOK)
}

func pushNotification(question *Question) {
	message := &messaging.Message{
		Data: map[string]string{
			"title": "Octopus Dashboard",
			"body":  "Acabaram de chegar perguntas de possíveis compradores",
		},
		Topic: topic,
	}

	client, err := app.Messaging(context.Background())
	if err != nil {
		log.Println("[firebase.initFirebase]", err)
	}

	_, err = client.Send(context.Background(), message)
	if err != nil {
		log.Println("[firebase.initFirebase]", err)
	} else {
		question.IsNotified = true
		updateQuestion(question)
	}
}
