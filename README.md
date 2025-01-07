# Remote Health Monitoring System

## Table of Contents
1. [Introduction](#introduction)
2. [System Overview](#system-overview)
3. [Technologies and Tools](#technologies-and-tools)
4. [Microservices Overview](#microservices-overview)
5. [Documentation Roadmap](#documentation-roadmap)
6. [Getting Started](#getting-started)

---

## 1. Introduction
The **Remote Health Monitoring System** is a personal project designed to practice and showcase expertise in building robust microservice architectures. It aims to implement and demonstrate the following concepts and technologies:
- **Design Principles**: SOLID, Domain-Driven Design (DDD), and Design Patterns.
- **Service Registry and API Gateway**: Managing service discovery and routing.
- **Asynchronous and Synchronous Communication**: Using RabbitMQ for messaging and REST for direct communication.
- **Multiple Databases**: SQL and NoSQL integration for optimized storage solutions.
- **Multiple Clouds**: Deployment across AWS and Heroku to simulate real-world cloud setups.
- **Real-Time Messaging**: Firebase for instant communication.
- **Centralized Logging**: Efficient logging using a centralized tool (e.g., Graylog or ELK Stack).

This project is structured and documented to serve as a portfolio example and a learning reference for modern system architecture.

---

## 2. System Overview
The **Remote Health Monitoring System** is designed to simulate and process health data from virtual devices. The system aims to solve the following problems:
- **Remote Health Tracking**: Enables monitoring of patient health metrics such as blood pressure, heart rate, and oxygen saturation.
- **Alerts and Notifications**: Sends real-time alerts to caregivers or healthcare professionals when a critical condition is detected.
- **Device and Patient Management**: Provides interfaces for managing medical devices and patient information.
- **Scalable Architecture**: Built to support horizontal scaling and robust data handling in real-time environments.

**Key Features**:
- Health data simulation and ingestion.
- Real-time alerting system with customizable thresholds.
- Multi-language microservices for a diversified and realistic setup.

---

## 3. Technologies and Tools
### Programming Languages
- **Java/Spring Boot**: For core backend services.
- **Python/Flask**: For lightweight and flexible services.

### Frameworks and Tools
- **Service Registry**: Spring Cloud Netflix Eureka for service discovery.
- **API Gateway**: Spring Cloud Gateway for centralized routing and policy management.
- **Asynchronous Messaging**: RabbitMQ for decoupled service communication.
- **Databases**: 
  - SQL: PostgreSQL (Heroku).
  - NoSQL: Firebase for real-time messaging and MongoDB for document storage.
- **Cloud Providers**:
  - **AWS**: For scalable backend services.
  - **Heroku**: For cost-effective deployment of simpler services.
- **Logging**: Centralized logging with Graylog (or ELK Stack as an alternative).
- **Documentation and Testing**:
  - Swagger/OpenAPI for API documentation.
  - JUnit for service testing.

---

## 4. Microservices Overview
This system is divided into multiple microservices, each with a distinct responsibility:

- **[Simulator Service](./services/python/ms-simulator/README.md)**: Simulates health data from virtual devices.
- **[Devices Service](./services/java/ms-devices/README.md)**: Manages the registration and tracking of medical devices.
- **[Patients Service](./services/java/ms-patients/README.md)**: Handles patient records and associations with devices.
- **[Alerts Service](./services/python/ms-alerts/README.md)**: Processes health data and triggers alerts when thresholds are exceeded.
- **[Notifications Service](./services/python/ms-notifications/README.md)**: Sends notifications via email, SMS, or push.
- **[Registry Service](./services/java/registry-service/README.md)**: Manages service discovery.
- **[Gateway Service](./services/java/gateway-service/README.md)**: Centralized entry point for routing API calls.

Each service is documented in detail within its respective folder.

---

## 5. Documentation Roadmap
The documentation for this system will be divided into the following sections:
1. **System Architecture**:
   - High-level architecture diagrams and design principles.
2. **Communication Patterns**:
   - Asynchronous and synchronous communication explained.
3. **Data Flow**:
   - How data flows across services, with examples.
4. **Deployment Strategies**:
   - Instructions for local, AWS, and Heroku deployments.
5. **Testing and Monitoring**:
   - Tools and processes for ensuring reliability and scalability.

---

## 6. Getting Started
To run this project locally, ensure you have the following tools installed:
- **Docker**: For containerized service deployment.
- **RabbitMQ**: For message brokering (can be run via Docker).
- **PostgreSQL**: As the main database (can be run via Docker).
- **Java 17**: For Spring Boot services.
- **Python 3.9+**: For Python-based services.

### Local Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/afranioag/remote-health-monitor.git
