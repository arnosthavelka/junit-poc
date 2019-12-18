# junit-poc
[![Travis Build Status][travis-image]][travis-url-main] [![Sonar quality gate][sonar-quality-gate]][sonar-url] [![Sonar coverage][sonar-coverage]][sonar-url] [![Sonar bugs][sonar-bugs]][sonar-url] [![Sonar vulnerabilities][sonar-vulnerabilities]][sonar-url]

This repository holds examples for my book [JUnit 5 - Unit testing on Java platform](http://knihy.pecinovsky.cz/54_junit5) (JUnit 5 - Jednotkové testování na platformě Java).
The main goal is to demonstrate usage of the framework JUnit 5.

## Pre-requisities
* JDK 11
* Maven 3.5
* Lombok (installed into the IDE)

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
1. **Framework JUnit 4** - demonstration of basic tests and usage of PowerMock framework. The demonstration of all JUnit 4 features is covered in [release 1.0](https://github.com/arnosthavelka/junit-poc/tree/1.0) and my theses [Analysis of architecture and extension model of the framework JUnit](https://theses.cz/id/p7ghon) (Analýza architektury a nadstavbových možností frameworku JUnit).
1. **Spring Boot** - demonstration of writing Spring Boot tests (including simple Spring tests example) dedicated to each layer (persistence, service and web). This part covers usage of **Spring REST Docs** to generate REST API documentation by the tests. 
1. **Cucumber** - exploration of writing tests according Behavior-Driven Development (BDD) methodology. The tests are executed by JUnit framework.

## Used Technologies

| Area          | Tool                  | Version      | Project                                | Description                              |
| ----------    | --------------------- | ------------ | -------------------------------------- | ---------------------------------------- |
| **General**   |                       |              |                                        |                                          |
|               | Maven                 | 3.5.x        | all                                    | Build                                    |
|               | Java                  | 11           | all                                    | Language Java  (code and tests)          |
|               | Kotlin                | 1.3.61       | ju-junit                               | Language Kotlin (tests only   )          |
|               | SLF4J                 | 1.7.28       | all                                    | Logging                                  |
|               | Lombok                | 1.18.10      | all                                    | Simplification of Java classes           |
| **Testing**   |                       |              |                                        |                                          |
|               | JUnit                 | 5.5.2        | ju-junit, ju-spring-boot, ju-cucumber  | Unit testing with JUnit5                 |
|               | Cucumber              | 4.8.0        | ju-cucumber                            | BDD testing                              |
|               | Spring Cloud Contract | 2.2.0        | ju-spring-boot                         | Contract / specification for REST services  |
| **Asserting** |                       |              |                                        |                                          |
|               | Hamcrest              | 1.3          | ju-junit, ju-spring-boot, ju-cucumber  | Assertions                               |
|               | AssertJ               | 3.14.0       | ju-junit, ju-spring-boot               | Assertions with Fluent API               |
|               | JSONAssert            | 1.5.0        | ju-junit                               | Assertions for JSON                      |
|               | JSONPath              | 2.4.0        | ju-junit                               | Assertions for JSON (used also by Spring |
| **Mocking**   |                       |              |                                        |                                          |
|               | Mockito               | 3.2.0        | ju-junit                               |                                          |
|               | EasyMock              | 4.1          | ju-junit                               |                                          |
|               | PowerMock             | 2.0.4        | ju-junit                               | Advanced mocking                         |
| **Others**    |                       |              |                                        |                                          |
|               | Spring Boot           | 2.2.1        | ju-spring-boot                         | Fast development of production ready applications |
|               | Liquibase             | by SB        | ju-spring-boot                         | Database management                      |
|               | JAX-B                 | by SB        | ju-spring-boot                         | XML binding                              |

[travis-url-main]: https://travis-ci.org/arnosthavelka/junit-poc
[travis-image]: https://travis-ci.org/arnosthavelka/junit-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_ju-root
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_ju-root&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_ju-root&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_ju-root&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_ju-root&metric=vulnerabilities
