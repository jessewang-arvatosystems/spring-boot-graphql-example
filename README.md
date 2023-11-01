Spring Boot Graph QL Example
====
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Based on the LinkedIn Learning Tutorial: "**Spring with GraphQL**".

This project is a simple example of how to use GraphQL with Spring Boot on a mock e-commerce dataset.

Requirements
---
- JDK 17 or greater
- Maven
- Any GraphQL Client, i.e., [Altair GraphQL](https://altairgraphql.dev/)
- Any Java IDE, i.e., [IntelliJ IDEA](https://www.jetbrains.com/idea/)

How to run
---
1. Open the project in the IDE
2. Navigate to `src/main/java/com/jesse.lil.hplus/HplusApplication.java` and run the `main` method
3. Open the GraphQL Client and use `http://localhost:8080/` as the endpoint

Spring Framework Configuration
---
The code base was initialized on https://start.spring.io with the following settings: 
- Project: **Maven**
- Language: **Java**
- Spring Boot: **3.1.5**
- Metadata
    - Group: **com.jesse.lil**
    - Artifact: **hplus**
    - Name: **hplus**
    - Description: **graphql in spring boot lesson**
    - Package name: **com.jesse.lil.hplus**
- Packaging: **Jar**
- Java: **17**
- Dependencies
    - **Spring Web**
    - **Spring GraphQL**
    - **Spring Data JPA**
    - **H2 Database**
    - **Spring Boot Actuator**

After importing this configuration, these files were deleted:
- .mvn
- HELP.md
- mvnw
- mvnw.cmd
