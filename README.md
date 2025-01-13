# NOT-UZUM E-Commerce Platform

An advanced e-commerce solution built with modern technologies, focusing on scalability and performance.

## 📑 Table of Contents
- [Overview](#overview)
- [System Architecture](#system-architecture)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Documentation](#documentation)
- [Contributing](#contributing)

## Overview
NOT-UZUM is a comprehensive e-commerce platform designed to provide a seamless shopping experience. The platform implements modern architectural patterns and best practices in software development.

## System Architecture
![System Architecture](./docs/images/system-architecture.png)

## Features
- 🔐 Advanced Authentication & Authorization
- 🛍️ Product Management
- 🛒 Shopping Cart Operations
- 💳 Payment Processing
- 📦 Order Management
- 📊 Analytics Dashboard
- 🔍 Smart Search with AI
- 📱 RESTful API endpoints

## Technology Stack
- **Backend:**
  - Java 21
  - Spring Boot 3.4.1
  - Spring Security
  - Spring Data JPA/MongoDB
- **Database:**
  - PostgreSQL
  - MongoDB
- **Tools & Others:**
  - Docker
  - Maven
  - Swagger/OpenAPI
  - JUnit 5

## Getting Started

### Prerequisites
- JDK 21
- Maven 3.9+
- Docker
- PostgreSQL 15+
- MongoDB 6+

### Installation
```bash
# Clone the repository
git clone https://github.com/yourusername/not-uzum.git

# Navigate to project directory
cd not-uzum

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## Project Structure
```plaintext
not-uzum/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── uz/pdp/notuzum/
│   │   │       ├── config/        # Configuration classes
│   │   │       ├── controller/    # REST controllers
│   │   │       ├── model/        # Domain models
│   │   │       ├── repository/    # Data access layer
│   │   │       ├── service/      # Business logic
│   │   │       └── security/     # Security configurations
│   │   └── resources/
│   └── test/
└── docs/
    ├── api/            # API documentation
    └── images/         # Project images and diagrams
```

## Documentation
- [API Documentation](./docs/api/README.md)
- [Setup Guide](./docs/setup.md)
- [Contributing Guidelines](./CONTRIBUTING.md)
- [Changelog](./CHANGELOG.md)

## Contributing
Please read our [Contributing Guidelines](./CONTRIBUTING.md) before submitting pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
