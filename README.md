# junit-poc
Demo project of usage of framework JUnit (version 4 & 5)

## Used Technologies

| Area        | Project                                               | Tool             | Version      | Description                 |
| ----------  | ----------------------------------------------------- | ---------------- | ------------ | --------------------------- |
| **General** |                                                       |                  |              |                             |
|             | all                                                   | Maven            | 3.x          | Build                       |
|             | all                                                   | JDK              | 10.0.2       | Java platform               |
|             | all                                                   | SLF4J            | 3.x          | Logging                     |
| **Testing** |                                                       |                  |              |                             |
|             | ju-junit4, ju-spring-ju4                              | JUnit            | 4.12         | Unit testing                |
|             | ju-junit5, ju-spring-ju5, ju-spring-boot, ju-cucumber | JUnit            | 5.3.0        | Unit testing                |
|             | ju-cucumber                                           | Cucumber         | 3.0.2        | BDD testing                 |
|             | all, ???                                              | Hamcrest         | 1.3          | Assertions                  |
|             | ju-junit5, ju-spring-ju5, ju-spring-boot              | AssertJ          | 3.10.0       | Assertions with Fluent API  |
| **Mocking** |                                                       |                  |              |                             |
|             | ju-junit4 - ???, ju-junit5, ju-spring-boot            | Mockito          | 2.19.0       |                             |
|             | ju-junit4                                             | EasyMock         | 3.6          |                             |
|             | ju-junit4                                             | PowerMock        | 2.0.0-beta.5 | Advanced mocking            |
| **Others** |                                                        |                  |              |                             |
|             | Spring Framework                                      | Spring Framework | 5.0.7        |                             |
|             | ju-spring-boot                                        | Spring Boot      | 2.0.3        |                             |
|             | ju-spring-boot                                        | Liquibase        | 3.5.5        | Database management         |


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

