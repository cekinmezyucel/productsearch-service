# Product Search Service
A Product Search Service Application Implementing a Postgres DB and ElasticSearch.

## Objective
The main objective of this project; build a complete application with a catalog based database and fuzzy searches with ElasticSearch.

### Tech
Product Search Service developed with Java 8, a number of technologies and open source projects:

* [SpringBoot]
* [PostgreSQL]
* [ElasticSearch]
* [GraphQL]
* [GraphiQL]
* [Docker]
* [Gradle]
* [JUnit]

## A brief schema for the project
![Alt text](./images/product_search_app_schema.PNG?raw=true "Title")

Please visit [Product Search Web] project.

## For Developers
To avoid build failures you must import these files (eclipse-code-formatter.xml, eclipse.importorder) to your IDE. The files are under the codequality folder.

### Installation
Stumpy requires [JDK8]. Please check your JAVA_HOME for success of build.
```sh
$ echo ${JAVA_HOME}
```

#### Docker

Composing containers. This command requires active internet connection for download PostgreSQL and ElasticSearch images.
```sh
$ cd ${project.basedir}/docker/
$ docker-compose up
```

This is a Gradle project. After the Docker initialization please run maven install command.
```sh
$ cd ${project.basedir}
$ gradle clean build
```

### Test Mutation With GraphiQL
http://localhost:8080/graphiql

New Brand Request
```json
mutation {
  newBrand(name: "Huawei"){
    id
    name
  }
}
```

New Brand Response
```json
{
  "data": {
    "newBrand": {
      "id": "1",
      "name": "Huawei"
    }
  }
}
```

New Model Request
```json
mutation {
  newModel(name: "MateBook X Pro" brandId: 1){
    id
    name
    brandResponse{
      id
      name
    }
  }
}
```

New Model Response
```json
{
  "data": {
    "newModel": {
      "id": "2",
      "name": "MateBook X Pro",
      "brandResponse": {
        "id": "1",
        "name": "Huawei"
      }
    }
  }
}
```


[SpringBoot]: <https://projects.spring.io/spring-boot/>
[PostgreSQL]: <https://www.postgresql.org/>
[Docker]: <https://www.docker.com/>
[JUnit]: <https://junit.org/>
[Gradle]: <https://gradle.org/>
[ElasticSearch]: <https://www.elastic.co/products/elasticsearch>
[JDK8]: <http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>
[GraphQL]: <https://graphql.org/>
[GraphiQL]: <https://electronjs.org/apps/graphiql>
[Product Search Web]: <https://github.com/cekinmezyucel/productsearch-web>