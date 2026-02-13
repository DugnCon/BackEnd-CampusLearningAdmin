cat > README.md << 'EOF'
# Campus Learning Admin - Backend System

Backend system for managing campus learning activities such as courses, users, and administrative operations.

Built with Java and Spring Boot using a clean layered architecture.

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Docker & Docker Compose

---

## Project Overview

Campus Learning Admin is a RESTful API designed to support a campus learning management system.

Main features:

- Manage users (students, teachers, admins)
- Manage courses
- Handle learning-related data
- Apply business logic through service layer

This project focuses on backend architecture, database design, and REST API development.

---

## Architecture

The project follows a layered architecture:

Controller -> Service -> Repository -> Database

- Controller: Handle HTTP requests
- Service: Business logic layer
- Repository: Data access layer using JPA
- Entity: Database mapping objects

This structure improves maintainability and scalability.

---

## Project Structure

src/
 └── main/
     ├── java/
     │   └── com/...
     │       ├── controller/
     │       ├── service/
     │       ├── repository/
     │       ├── entity/
     │       └── config/
     └── resources/
         ├── application.yml
         └── ...

---

## Setup and Run

### Option 1: Run with Docker

docker-compose up --build

---

### Option 2: Run Locally

1. Clone repository

git clone https://github.com/DugnCon/BackEnd-CampusLearningAdmin.git
cd BackEnd-CampusLearningAdmin

2. Configure database in application.yml

3. Run application

mvn spring-boot:run

Server runs at:

http://localhost:8080

---

## API Example

Example request:

GET /api/courses

Example response:

{
  "id": 1,
  "name": "Backend Development",
  "description": "Spring Boot course"
}

---

## Docker Support

The project includes:

- Dockerfile
- docker-compose.yml

This allows containerized deployment and easier environment setup.

---

## Future Improvements

- JWT Authentication
- Role-based Authorization
- Swagger API Documentation
- Unit and Integration Testing
- CI/CD pipeline

---

## Author

DugnCon
https://github.com/DugnCon

EOF
