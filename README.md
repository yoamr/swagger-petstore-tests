Swagger Petstore API Test Automation
=====================================

This project provides a REST API test automation suite for the Swagger Petstore `User` endpoint using:

- Java 17+
- JUnit 5
- Jackson (for JSON data binding)
- RestAssured
- Maven
- Surefire Reports
- Optional: Docker for environment isolation

-----------------------------------------------------
Setup Steps
-----------------------------------------------------

1. Clone the Repository

   git clone https://github.com/yoamr/swagger-petstore-tests/tree/feature/api-tests

   cd swagger-petstore

2. Ensure Java 17+ is installed

   Check your version:
   java -version

3. Build the Project

   mvn clean compile

-----------------------------------------------------
Running the Tests
-----------------------------------------------------

You can run all test cases using Maven:

   mvn test

The test results will be printed in the console and available in the generated report at:

   target/surefire-reports/

-----------------------------------------------------
Test Report
-----------------------------------------------------

After execution, test reports are generated in:

   target/surefire-reports/

Check the .txt files or open index.html if configured for HTML output.

-----------------------------------------------------
Test Data & Data Provider
-----------------------------------------------------

User data is provided through an external JSON file located in:

   src/test/resources/data/userData.json

This file is loaded in the tests using:

   List<User> users = TestDataReader.readUsers("data/userData.json");

This allows data-driven tests for Create, Update, and Delete operations.

-----------------------------------------------------
Summary of Covered Features
-----------------------------------------------------

- Create User
- Get User by Username
- Update User
- Delete User
- Data-driven testing via external JSON
- Maven Surefire reporting
