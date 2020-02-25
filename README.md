# Data service playground

Simple initial poc that currently returns data in json and text/csv formats.
Grpc interface added, needs to be updated to the stream


## Build

Prerequisites: java and maven have to be installed

```
mvn package
```
## Start

```
java -jar target/data-service-poc-0.0.1-SNAPSHOT.jar
```

## Call examples

* curl -H "Accept: application/json" localhost:8080/v1/records
* curl -H "Accept: text/csv" localhost:8080/v1/records
* curl -H "Accept: application/octet-stream" localhost:8080/v1/records