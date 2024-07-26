
# Employee Records Management System

This Spring Boot application manages employee records using an in-memory H2 database and exposes endpoints for CRUD operations through both REST API and gRPC.

## Prerequisites

* Java 17

* Maven 3

* Spring Boot 3

* Docker

## Features

* Maintains employee records in H2 database.
* Exposes endpoints for creating, reading, updating, and deleting employee records.
* Provides endpoints in both REST API and gRPC formats.

## Endpoints

### REST API

* Get all employees
* Get a specific employee
* Create a new employee
* Delete an employee

### gRPC
Defined in the proto file: employee.proto

## Configuration

* REST API: Runs on port 8081 (configurable in the properties file)
* gRPC: Runs on port 9090 (configurable in the properties file)

## Swagger Documentation

Access the Swagger UI for API documentation at: Swagger UI

## Build and Run

#### Maven
Use the following Maven command to clean, install, and generate the necessary classes and jar file:

    mvn clean install
#### Docker
##### Build Docker Image

    docker build -t my-spring-boot-app .

##### Start Docker Container

    docker run -p 8081:8081 -p 9090:9090 -d my-spring-boot-app

## Getting Started

1. Clone the repository:

        git clone https://github.com/partheebanMani/springboot-restapi-grpc


2. Navigate to the project directory:

        cd springboot-restapi-grpc


3. Build the project using Maven:

        mvn clean install


4. Build and run the Docker container:

       docker build -t my-spring-boot-app .
       docker run -p 8081:8081 -p 9090:9090 -d my-spring-boot-app

5. Access the REST API documentation via Swagger UI at http://localhost:8081/swagger-ui/index.html#/.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue for any changes or enhancements.