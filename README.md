# BackEnd-CampusLearningAdmin
🎓 Campus Learning Admin – Backend System

A backend system for managing campus learning activities including courses, users, and administration features.
Built with Java and Spring Boot following a clean layered architecture.

🚀 Tech Stack

☕ Java 17+

🌱 Spring Boot

🗄 Spring Data JPA

🐬 MySQL

🐳 Docker & Docker Compose

🔐 (Optional) Spring Security / JWT

📌 Project Overview

Campus Learning Admin is a RESTful backend API designed to support a campus learning management system.

The system allows administrators to:

Manage users (students, teachers, admins)

Manage courses

Handle learning-related data

Control access and business logic

This project focuses on backend architecture, database design, and REST API development.

🏗 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database


Controller: Handle HTTP requests

Service: Business logic layer

Repository: Data access layer (JPA)

Entity: Database mapping objects

This structure improves maintainability and scalability.

📂 Project Structure
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

⚙️ Setup & Run
🔹 Option 1: Run with Docker
docker-compose up --build


The application will start along with the database.

🔹 Option 2: Run Locally

Clone repository

git clone https://github.com/DugnCon/BackEnd-CampusLearningAdmin.git
cd BackEnd-CampusLearningAdmin


Configure database in application.yml

Run application

mvn spring-boot:run


Server runs at:

http://localhost:8080

📡 API Example

Example request:

GET /api/courses


Example response:

[
  {
    "id": 1,
    "name": "Backend Development",
    "description": "Spring Boot course"
  }
]

🐳 Docker Support

This project includes:

Dockerfile

docker-compose.yml

Allows containerized deployment for easier environment setup.

🔐 Future Improvements

Add JWT Authentication

Role-based Authorization (Admin / Teacher / Student)

Swagger API Documentation

Unit & Integration Testing

CI/CD pipeline

🎯 Purpose

This project was developed for:

Practicing backend development

Learning system architecture design

Demonstrating Java Spring Boot skills

👨‍💻 Author

Developed by DugnCon
GitHub: https://github.com/DugnCon
