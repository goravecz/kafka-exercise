# kafka-exercise
This app is about keeping track of beer orders. It has two parts: a producer and a consumer.

## Flow
- The producer can be populated with beer orders via JSON requests. Example request:
```json
{
  "content": "abrakadabra IPA",
  "timestamp": "2018-10-09 00:12:12+0100"
}
```
- The payload is published to a Kafka broker by the producer.
- The consumer fetches the beer orders and enriches the order with the length of the longest palindrome found in the ```content``` node.
- (WIP) The consumer persists the enriched beer order to a MongoDB.
- (WIP) The consumer has an endpoint to query every beer order in the DB.

## Technologies used
- Java 11
- Spring Boot
- Kafka
- Docker

## Set up locally
1. Clone the repository
2. Build it by ```mvn clean install```
3. Run it by ```docker-compose up```
4. Inspect the beer orders on a GUI by KafDrop on ```localhost:9000```
