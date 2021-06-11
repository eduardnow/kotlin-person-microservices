# Challenge - Kotlin/Spring/Kafka

Create two microservices based on Spring Boot and Kotlin. They store a Person entity.

## Getting Started

### Dependencies

* Java 8
* Kotlin 1.5
* Docker 20.x
* Gradle 6.x
* Make

### Installing

To facilitate the installation, you can run the command (GNU Make is required):

```bash
 make init # Start and run containers
```
Details: Makefile

### Executing program

```bash
 make run # Run containers
```

```bash
 make stop # Stop containers
```

```bash
 make broker # Stop containers
```

```bash
 make psql # Stop containers
```

## Exposed API


#### Create a new person

```bash
curl --location --request POST 'http://localhost:9080/person-api/v1/persons' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstname": "Joe",
    "lastname": "Doe"
}'

```

Response:
```bash

HTTP 201 Created
Location: /5e322fe4-047d-42bf-bdd9-690f0bd5fcee # Person code

```	

#### Update a person

```bash
# Replace with existing person code (3de246e4-3b7e-4a0f-a210-e4b9a0a8b449)

curl --location --request PUT 'http://localhost:9080/person-api/v1/persons/3de246e4-3b7e-4a0f-a210-e4b9a0a8b449' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstname": "Mary",
    "lastname": "Doe"
}'

```

Response:
```bash

HTTP 204 No Content

```