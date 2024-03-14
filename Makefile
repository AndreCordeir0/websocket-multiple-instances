
all: build build-image run
build:
	./mvnw package -DskipTests=true
build-image:
	docker build -f src/main/docker/Dockerfile.jvm -t quarkus/websocket-multiple-instances .
run:
	docker-compose up -d
stop:
	docker-compose down