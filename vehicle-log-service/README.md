# VehicleLog-Service Module Low-Level Documentation

This document provides a low-level overview of the `VehicleLog-Service` module, a microservice within the Parking Management System (PMS) responsible for managing vehicle entry and exit operations.

---

 ## Table of Contents

1. [Project Overview](#1-project-overview)
   - [1.1 Features](#11-features)
2. [Architecture](#2-architecture)
   - [2.1 Component Diagram](#21-component-diagram)
   - [2.2 Sequence Diagram](#22-sequence-diagram)
3. [Database Design](#3-database-design)
   - [3.1 VehicleLog-Service Table](#31-vehiclelog-service-table)
4. [API Endpoints](#4-api-endpoints)
   - [4.1 Vehicle Log Management](#41-vehicle-log-management)
   - [4.2 Swagger Documentation](#42-swagger-documentation)
5. [Error Handling](#5-error-handling)
   - [5.1 Common Error Codes](#51-common-error-codes) 
6. [Maven Dependencies](#6-maven-dependencies)
7. [Deployment](#7-deployment)
   - [7.1 Steps to Deploy](#71-steps-to-deploy)


 

   
## 1. Project Overview

The `VehicleLog-Service` module is a core component of the Parking Management System (PMS), dedicated to tracking vehicle movements. It handles operations such as logging vehicle entry and exit, updating parking slot occupancy, and calculating parking duration for billing purposes.

### 1.1 Features

- **Log vehicle entry**
  - Records the entry time of a vehicle into a parking slot.
  - Validates slot availability and user association.
  - Updates the slot status to occupied.

- **Log vehicle exit**
  - Records the exit time of a vehicle from a parking slot.
  - Calculates the total duration of parking.
  - Updates the slot status to available.

- **Retrieve vehicle log by ID**
  - Enables fetching specific vehicle log details using a unique log ID.
  - Returns entry time, exit time, vehicle number, slot ID, and user ID.

- **Retrieve all vehicle logs**
  - Provides functionality to fetch all vehicle logs in the system.
  - Supports pagination and filtering for efficient data handling.
  - Returns a list of logs with basic details.

---

## 2. Architecture

The `VehicleLog-Service` module is built using the **Spring Boot** framework and adheres to a **layered architecture**. It communicates with other services via **REST APIs** and utilizes **H2** as its database for local development purposes.

### 2.1 Component Diagram

```mermaid
flowchart LR
 
  %% Groups

  subgraph Frontend [React Frontend]

    direction TB

    A1[Entry/Exit UI Components]

    A2[VehicleLog API Client]

  end
 
  subgraph Backend [Spring Boot Backend]

    direction TB

    B1[VehicleLogController]

    B2[VehicleLogService]

    B3[VehicleLogRepository]

  end
 
  subgraph Database [Relational Database]

    direction TB

    C1[(VehicleLog Table)]

  end
 
  %% Entity and DTO

  D1[VehicleLog DTO]

  D2[VehicleLog Entity]
 
  %% Connections

  A2 -->|HTTP/REST| B1

  B1 -->|Calls| B2

  B2 -->|Calls| B3

  B3 -->|ORM / JDBC| C1
 
  B1 ---|uses| D1

  B3 ---|maps to| D2
 
  %% Styling

  classDef frontend fill:#dae8fc,stroke:#6c8ebf,color:#1a237e

  classDef backend fill:#d5e8d4,stroke:#82b366,color:#1b4332

  classDef storage fill:#e8def8,stroke:#8e44ad,color:#4a148c

  classDef model fill:#fff2cc,stroke:#d6b656,color:#7f4f24
 
  class A1,A2 frontend

  class B1,B2,B3 backend

  class C1 storage

  class D1,D2 model

 
```
### 2.2 Sequence Diagram

```mermaid
sequenceDiagram
    participant Staff
    participant API Gateway
    participant VehicleLogService
    participant VehicleLogDB

    Staff->>API Gateway: POST /api/vehicle-log/entry (VehicleLog object)
    API Gateway->>VehicleLogService: Route request
    VehicleLogService->>VehicleLogService: Validate slot and user
    VehicleLogService->>VehicleLogDB: Save entry log
    VehicleLogDB-->>VehicleLogService: Entry log saved
    VehicleLogService-->>API Gateway: Response with log details
    API Gateway-->>Staff: Response with log details
```

## 3. Database Design

### 3.1 VehicleLog-Service Table

The `VehicleLog-Service` module utilizes the following table:


| Column Name     | Data Type | Description                          |
|-----------------|-----------|--------------------------------------|
| `logId`         | Long      | Primary key (auto-generated)         |
| `vehicleNumber` | String    | Vehicle registration number          |
| `entryTime`     | Timestamp | Time of vehicle entry                |
| `exitTime`      | Timestamp | Time of vehicle exit                 |
| `slotId`        | String    | Foreign key to ParkingSlot           |
| `userId`        | String    | Foreign key to User                  |

---

## 4. API Endpoints

### 4.1 Vehicle Log Management

| Endpoint                        | Method | Description           | Request Body/Params     |
|--------------------------------|--------|-----------------------|--------------------------|
| `/api/vehicle-log/entry`       | POST   | Log vehicle entry     | VehicleLog object        |
| `/api/vehicle-log/exit/{logId}`| POST   | Log vehicle exit      | `logId` (Path Variable)  |
| `/api/vehicle-log`             | GET    | Retrieve all logs     | None                     |


### 4.2 Swagger Documentation

Detailed API documentation can be found via Swagger UI, typically available at `/swagger-ui.html` when the service is running.

---

## 5. Error Handling

The module leverages Spring Boot's exception handling mechanisms to return appropriate HTTP status codes for errors, ensuring clear communication of issues to client applications.

### 5.1 Common Error Codes

| Error Code | Description           |
|------------|-----------------------|
| `400`      | Bad Request           |
| `404`      | Resource Not Found    |
| `500`      | Internal Server Error |

---

## 6. Maven Dependencies

The `pom.xml` file defines the project's dependencies and build configuration. Key dependencies include:

- **spring-boot-starter-web**: For RESTful web applications.
- **spring-boot-starter-data-jpa**: For JPA and Hibernate integration.
- **spring-boot-starter-actuator**: For monitoring and management.
- **spring-boot-starter-security**: For security features (if implemented).
- **spring-boot-starter-test**: For unit and integration testing. 
- **spring-cloud-starter-netflix-eureka-client**: Enables service registration with Eureka.
- **lombok**: Reduces boilerplate Java code.
- **mysql-connector-j**: JDBC driver for MySQL database connection.
- **springdoc-openapi-starter-webmvc-ui**: Generates OpenAPI (Swagger) documentation.
- **spring-boot-devtools**: Provides development-time features like automatic restarts.


---

## 7. Deployment

 
#### Key Configuration
 
Below is an excerpt from the `application.properties` file:
 
```properties
spring.application.name=vehiclelog-service
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/vehiclelog_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
eureka.instance.hostname=localhost
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
```
 
#### 7.1 Steps to Deploy
 
1. **Clone the Repository**  
    ```bash
    git clone <repository-url>
    ```
 
2. **Navigate to the Project Directory**  
    ```bash
    cd vehiclelog-service
    ```
 
3. **Build the Project**  
    ```bash
    mvn clean install
    ```
 
4. **Run the Application**  
    ```bash
    mvn spring-boot:run
    ```
 
Ensure that the Eureka server and MySQL database are running before starting the application.
 
---
 
### Note
 
Ensure MySQL is running and the `parking_db` database exists.  
Eureka server should be running on port `8761` for service registration.  
Swagger UI is available at `/swagger-ui.html` for API exploration.  
