# junit-poc
[![Travis Build Status][travis-image]][travis-url-main] [![sonar-quality-gate][sonar-quality-gate]][sonar-url] [![sonar-coverage][sonar-coverage]][sonar-url] [![sonar-bugs][sonar-bugs]][sonar-url] [![sonar-vulnerabilities][sonar-vulnerabilities]][sonar-url]

This repository holds examples for my book [JUnit 5 - over the border of unit testing](http://knihy.pecinovsky.cz/54_junit5) (JUnit 5 - za hranice jednotkového testování).
The main goal is to demonstrate usage of the framework JUnit 5.

## Decomposition of projects
![Build model](build-model.png?raw=true "Build model")

## Features
 Moreover there are some topics related to these areas:
1. **Framework JUnit 5** - demonstration of all JUnit 5 covers:
    1. Features: 
        1. All basic annotations
        1. Dynamic & nested tests
        1. Interface default method (idm)
    1. Extension model:
        1. Declarative and programmatic registration
        1. Parameter resolver
        1. Exception handler
    1. And more
1. **Framework JUnit 4** - demonstration of all JUnit 4 features used in my theses [Analysis of architecture and extension model of the framework JUnit](https://theses.cz/id/p7ghon) (Analýza architektury a nadstavbových možností frameworku JUnit). Included features are:
    1. Runners
    1. Rules
    1. Validaton
1. **Spring Framework** - some examples of writing Spring tests.
1. **Spring Boot** - demonstration of writing Spring Boot tests dedicated to each layer (persistence, service and web). This part covers usage of **Spring REST Docs** to generate REST API documentation by the tests. 
1. **Cucumber** - exploration of writing tests according Behavior-Driven Development (BDD) methodology. The tests are executed by JUnit framework.

## Used Technologies

| Area        | Tool             | Version      | Project                                               | Description                 |
| ----------  | ---------------- | ------------ | ----------------------------------------------------- | --------------------------- |
| **General** |                  |              |                                                       |                             |
|             | Maven            | 3.x          | all                                                   | Build                       |
|             | JDK              | 10.0.2       | all                                                   | Java platform               |
|             | SLF4J            | 1.7.25       | all                                                   | Logging                     |
| **Testing** |                  |              |                                                       |                             |
|             | JUnit            | 4.12         | ju-junit4, ju-spring-ju4                              | Unit testing                |
|             | JUnit            | 5.3.1        | ju-junit5, ju-spring-ju5, ju-spring-boot, ju-cucumber | Unit testing                |
|             | Cucumber         | 3.0.2        | ju-cucumber                                           | BDD testing                 |
|             | Hamcrest         | 1.3          | ju-junit4, ju-spring-boot, ju-cucumber                | Assertions                  |
|             | AssertJ          | 3.11.1       | ju-junit5, ju-spring-ju5, ju-spring-boot              | Assertions with Fluent API  |
| **Mocking** |                  |              |                                                       |                             |
|             | Mockito          | 2.22.0       | ju-junit4 - ???, ju-junit5, ju-spring-boot            |                             |
|             | EasyMock         | 3.6          | ju-junit4                                             |                             |
|             | PowerMock        | 2.0.0-beta.5 | ju-junit4                                             | Advanced mocking            |
| **Others**  |                  |              |                                                       |                             |
|             | Spring Framework | 5.0.9        | ju-spring-ju4, ju-spring-ju5                          |                             |
|             | Spring Boot      | 2.0.5        | ju-spring-boot                                        |                             |
|             | Liquibase        | 3.5.5        | ju-spring-boot                                        | Database management         |

[travis-url-main]: https://travis-ci.org/arnosthavelka/junit-poc
[travis-image]: https://travis-ci.org/arnosthavelka/junit-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_junit-poc
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=vulnerabilities
