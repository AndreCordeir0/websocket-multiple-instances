# websocket-multiple-instances

This project aims to create a WebSocket service using Apache Kafka to handle communication between multiple instances. It utilizes Kafka as a messaging system to enable real-time communication between clients and servers across distributed environments.


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

Run docker-compose with native image
```shell script
  make all-native
```

Run docker-compose with JVM
```shell script
  make all
```