# Automated API Testing Framework - Trello API

## Project Overview

This project is an automated testing framework built using **Rest Assured** and **Java**. It focuses on testing the **Atlassian Trello API** to ensure functionality and reliability across different API endpoints.

## Features

- Automated testing of the Trello API
- Supports running regression tests and full test suites
- Integrated with GitHub Actions for continuous integration and automated testing

## Requirements

To run this project, ensure the following are installed:

- **Java 8** or higher
- **Maven** (to manage dependencies and run tests)

## Getting Started

Clone the repository and navigate to the project directory:

```bash
git clone <repository-url>
cd <project-directory>
```
Run Regression Tests:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=regresion.xml
```

Run All tests
```bash
mvn clean install
```

<a href="https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-actions-id-get">URL of documentation</a>
