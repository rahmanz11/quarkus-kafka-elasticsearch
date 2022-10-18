# kpalmab Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
mvn clean install quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn clean package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
mvn clean package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
mvn clean package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
mvn clean package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/kpalmab-1.0.0-SNAPSHOT-runner`

## Run everything at once
You can run redpanda, elasticsearch and the java app all along by running the docker-compose.yml file from the project parent directory:
```shell script
docker-compose up
```
Do make everything down:
```shell script
docker-compose down
```
## Technologes:
This application has developed using the following technologes: 
    
    1. Quarkus platform - version: 2.13.2.Final
    2. Redpanda Kafka - version: 21.11.8
    3. Elasticsearch - version: 7.17.6
    4. Kibana - version: 7.17.6 (To view elasticsearch data- http://localhost:5601)

## Workflow

When the quarkus-app starts:

**_1._** 3 producer classes under the org.demo.producer package runs parallely and start producing data to the redpanda kafka in 3 topics: parent, child and update using the respective json files located under resources/data folder.
    
**_2._** While the producer classes produces data to the topics, the consumer class, located under the org.demo.consumer package starts consuming the messages.

**_3._** After consumption, the data is sent to the ElasticsearchService class to insert them into the database.

**_4._** Keeping the distributed manner in consideration, the presence of the parent data has ensured properly from the consumer class.
    