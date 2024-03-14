
all: build build-image run
build:
	./mvnw package -DskipTests=true
build-image:
	docker build -f src/main/docker/Dockerfile.jvm -t quarkus/websocket-multiple-instances .
run:
	docker-compose up -d
stop:
	docker-compose down


all-native: build-native build-image-native run
build-native:
	./mvnw package -DskipTests=true -Dnative
build-image-native:
	docker build -f src/main/docker/Dockerfile.native -t quarkus/websocket-multiple-instances .