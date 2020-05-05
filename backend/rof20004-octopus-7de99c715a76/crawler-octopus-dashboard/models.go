package main

type Blacklist struct {
	ID   int64  `json:"id"`
	Text string `json:"text"`
}

type Product struct {
	ID   int64  `json:"id"`
	Name string `json:"name"`
	Link string `json:"link"`
}

type Question struct {
	ID         int64  `json:"id"`
	Text       string `json:"text"`
	IsNotified bool   `json:"is_notified"`
	IsRelevant bool   `json:"is_relevant"`
	ProductID  int64  `json:"product_id"`
}
