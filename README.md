# junit-poc
This repository holds examples for my book `JUnit 5 - over the border of unit testing` (JUnit 5 - za hranice jednotkového testování). The main goal is to demonstrate usage of the framework JUnit 5. Moreover there are some topics related to these areas:
1.  **Framework JUnit 4** - demonstration of all JUnit 4 features used in my theses [Analysis of architecture and extension model of the framework JUnit](https://theses.cz/id/p7ghon) (Analýza architektury a nadstavbových možností frameworku JUnit).
1.  **Spring Framework** - some examples of writing Spring tests.
1.  **Spring Boot** - demonstration of writing Spring Boot tests dedicated to each layer (persistence, service and web). This part covers usage of **Spring REST Docs** to generate REST API documentation by the tests. 
1.  **Cucumber** - exploration of writing tests according Behavior-Driven Development (BDD) methodology. The tests are executed by JUnit framework.

## Used Technologies

| Area        | Tool             | Version      | Project                                               | Description                 |
| ----------  | ---------------- | ------------ | ----------------------------------------------------- | --------------------------- |
| **General** |                  |              |                                                       |                             |
|             | Maven            | 3.x          | all                                                   | Build                       |
|             | JDK              | 10.0.2       | all                                                   | Java platform               |
|             | SLF4J            | 3.x          | all                                                   | Logging                     |
| **Testing** |                  |              |                                                       |                             |
|             | JUnit            | 4.12         | ju-junit4, ju-spring-ju4                              | Unit testing                |
|             | JUnit            | 5.3.0        | ju-junit5, ju-spring-ju5, ju-spring-boot, ju-cucumber | Unit testing                |
|             | Cucumber         | 3.0.2        | ju-cucumber                                           | BDD testing                 |
|             | Hamcrest         | 1.3          | all, ???                                              | Assertions                  |
|             | AssertJ          | 3.10.0       | ju-junit5, ju-spring-ju5, ju-spring-boot              | Assertions with Fluent API  |
| **Mocking** |                  |              |                                                       |                             |
|             | Mockito          | 2.19.0       | ju-junit4 - ???, ju-junit5, ju-spring-boot            |                             |
|             | EasyMock         | 3.6          | ju-junit4                                             |                             |
|             | PowerMock        | 2.0.0-beta.5 | ju-junit4                                             | Advanced mocking            |
| **Others**  |                  |              |                                                       |                             |
|             | Spring Framework | 5.0.7        | ju-spring-ju4, ju-spring-ju5                          |                             |
|             | Spring Boot      | 2.0.3        | ju-spring-boot                                        |                             |
|             | Liquibase        | 3.5.5        | ju-spring-boot                                        | Database management         |


## Features
* examples for most of JUnit features
* examples of custom extensions (usage of extension model)
  * JUnit 4
    * Rule
    * Runner
    * Validation
  * JUnit 5
    * ParamResolver
    * ExtendWith
* usage of testing with Spring
  * Spring Framework
  * Spring Boot
* usage of testing with Cucumber

## Build Model
![Build model](build-model.png?raw=true "Build model")

