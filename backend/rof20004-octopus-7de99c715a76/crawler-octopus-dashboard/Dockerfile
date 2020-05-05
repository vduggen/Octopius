FROM golang:alpine AS builder
WORKDIR /app
COPY . .
RUN go mod download
RUN CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build -ldflags="-w -s" -o crawler

FROM alpine
COPY --from=builder /app/crawler crawler
EXPOSE 8080
CMD ["./crawler"]

