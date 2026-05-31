# CRM Contact API

A Spring Boot REST API that integrates with Salesforce and exposes CRUD operations for Contact records.

This project was built to practice:

- Java 21
- Spring Boot
- REST API development
- Salesforce REST API integration
- OAuth 2.0 Client Credentials flow
- Maven project structure
- Environment-specific configuration using Spring Profiles

---

## Features

### Contact Operations

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | `/contacts` | Get all contacts |
| GET | `/contacts/{id}` | Get a contact by ID |
| POST | `/contacts` | Create a contact |
| PUT | `/contacts/{id}` | Update a contact |
| DELETE | `/contacts/{id}` | Delete a contact |

---

## Tech Stack

- Java 21
- Spring Boot 4
- Maven
- Salesforce External Client App Integration
- IntelliJ IDEA

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.crmcontactapi
    │       ├── controller
    │       ├── service
    │       ├── salesforce
    │       ├── model
    │       └── dto
    └── resources
        ├── application.properties
        └── application-dev.properties
```
## Running Locally

1. Create:

`src/main/resources/application-dev.properties`

2. Add your Salesforce credentials.

3. In IntelliJ IDEA:

Run → Edit Configurations → Spring Boot

Set:

```text
Active Profiles: dev
