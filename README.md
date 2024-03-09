# Parking-Management-System



## Project Presention [Video](link/to/documentation):



## Description

A Parking Management System efficiently organizes and monitors parking spaces, providing users with real-time availability information. It optimizes parking utilization, streamlines entry and exit processes, and enhances overall security through surveillance and automated payment systems.

## Key Features:

Space Tracking: Real-time monitoring for available parking spots, minimizing search time.
Payment Automation: Integration of mobile apps or kiosks for streamlined payments.
Entry/Exit Automation: Automated gates or plate recognition for smoother traffic flow.


## Tech-Stacks:
    - Backend: Java, Spring-Boot, Spring-Data-JPA
    - Database: MYSQL.
    

## Database
<img src="https://i.ibb.co/JFcZkH4/ER-Diagram.png" alt="Alt Text" width="700"/>



## Project Configuration

The project uses the following configuration for the Spring Boot application:

```properties
server.port = 5050
#To configuer your own server port please follow the path provided below and change the server.port value;
#Parking-Management-Backend\src\main\resources/src/main/resources/application.yml

server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/parking_system
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
     ddl-auto: update
    show-sql: true
    format_sql: true
    properties:
      dialect : org.hibernate.dialect.MySQL8Dialect

```
## Setup

To run the application, follow these steps:

1. Ensure you have Java and MySQL installed on your system.

2. Set up the database with the provided connection details in the `application.yml`.

3. Run the Spring Boot application.

4. Access the application using the specified port (e.g., http://localhost:8080).

## Future implementation:
1. We are also planing to implement Payment Gateway for this application.
2. And also an user friendly user interface.


    
