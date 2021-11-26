# junit-poc
[![Travis Build Status][travis-image]][travis-url-main] [![Sonar quality gate][sonar-quality-gate]][sonar-url] [![Sonar coverage][sonar-coverage]][sonar-url] [![Sonar bugs][sonar-bugs]][sonar-url] [![Sonar vulnerabilities][sonar-vulnerabilities]][sonar-url] [![MIT licensed][mit-badge]](./LICENSE.txt)


This repository holds examples for my book [JUnit 5 - Unit testing on Java platform](http://knihy.pecinovsky.cz/54_junit5) (JUnit 5 - Jednotkové testování na platformě Java).
The main goal is to demonstrate usage of the framework JUnit 5.

## Pre-requisities
* JDK 17
* Maven 3.8
* Lombok (installed into the IDE)

## Decomposition of projects
![Build model](build-model.png?raw=true "Build model")

## Features
 Moreover there are some topics related to these areas:
1. **Framework JUnit** - demonstration of all JUnit 5 covers:
    1. Features: 
        1. All basic annotations
        1. Dynamic & nested tests
        1. Interface default method (idm)
    1. Extension model:
        1. Declarative and programmatic registration
        1. Parameter resolver
        1. Exception handler
    1. Usage of Kotlin
    1. And more
1. **Spring Boot** - demonstration of writing Spring Boot tests (including simple Spring tests example) covers:
    1. Tests for each layer
    	1. Persistence (including Liquibase)
    	1. Service
    	1. REST service (including JSON assertions)
    1. Usage of **Spring REST Docs** to generate REST API documentation by the tests
    1. Usage of Spring Cloud Contract 
1. **Cucumber** - exploration of writing tests according Behavior-Driven Development (BDD) methodology. The tests are executed by JUnit framework.
1. **REST testing** - demonstration of test for REST services (Spring Cloud Contract or REST Assured) or JSON content itself (JSONAssert or JSONPath).

## Used Technologies

| Area          | Tool                  | Version      | Project                                | Description / Usage                      |
| ----------    | --------------------- | ------------ | -------------------------------------- | ---------------------------------------- |
| **General**   |                       |              |                                        |                                          |
|               | Maven                 | 3.8.x        | all                                    | Build                                    |
|               | Java                  | 17           | all                                    | Language Java  (code and tests)          |
|               | Kotlin                | 1.6.0        | ju-junit                               | Language Kotlin (tests only   )          |
|               | SLF4J                 | 1.7.32       | all                                    | Logging                                  |
|               | Lombok                | 1.18.22      | all                                    | Simplification of Java classes           |
| **Testing**   |                       |              |                                        |                                          |
|               | JUnit                 | 5.8.1        | ju-junit, ju-spring-boot, ju-cucumber  | Unit testing with JUnit5                 |
|               | Cucumber              | 7.0.0        | ju-cucumber                            | BDD testing (Note: lamda feature was removed due to missing support for JDK14)                             |
|               | Spring Cloud Contract | 3.0.4        | ju-spring-boot                         | Contract / specification for REST services |
| **Asserting** |                       |              |                                        |                                          |
|               | Hamcrest              | 1.3          | ju-junit, ju-spring-boot, ju-cucumber  | Assertions                               |
|               | AssertJ               | 3.21.0       | ju-junit, ju-spring-boot               | Assertions with Fluent API               |
|               | JSONAssert            | 1.5.0        | ju-junit                               | Assertions for JSON                      |
|               | JSONPath              | 2.6.0        | ju-junit                               | Assertions for JSON (used also by Spring |
|               | Rest Assured          | 4.4.0        | ju-spring-boot                         | Assertions for REST service              |
| **Mocking**   |                       |              |                                        |                                          |
|               | Mockito               | 4.0.0        | ju-junit                               |                                          |
|               | EasyMock              | 4.3          | ju-junit                               |                                          |
| **Others**    |                       |              |                                        |                                          |
|               | Spring Boot           | 2.5.7        | ju-spring-boot                         | Fast development of production ready applications |
|               | Liquibase             | by SB        | ju-spring-boot                         | Database management                      |
|               | JAX-B                 | by SB        | ju-spring-boot                         | XML binding                              |

[travis-url-main]: https://app.travis-ci.com/github/arnosthavelka/junit-poc
[travis-image]: https://travis-ci.com/arnosthavelka/junit-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_junit-poc
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_junit-poc&metric=vulnerabilities
[mit-badge]: https://img.shields.io/badge/license-MIT-maroon.svg
