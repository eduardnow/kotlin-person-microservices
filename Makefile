
.PHONY: volumen
volumen:
	docker volume create --name=person-postgresql-volume --driver local

.PHONY: stop
stop:
	docker-compose down
	@echo "That is all"

.PHONY: psql
psql:
	docker exec -it database-service psql -U postgres

.PHONY: run
run:
	docker-compose down
	sh init.sh
	docker-compose up -d --build
	@echo "That is all"

.PHONY: init
init: volumen run

.PHONY: broker
broker:
	docker-compose exec kafka kafka-console-consumer --topic tech.eduardnow.test.person --from-beginning --bootstrap-server localhost:9092
