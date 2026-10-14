# First Spring API — Task Management REST API

A RESTful API built with **Java, Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL** to manage tasks. This project is part of my journey learning backend development with Spring Boot.

## Features

- Retrieve all tasks
- Retrieve tasks by ID
- Create new tasks
- Update existing tasks
- Delete tasks
- Persist data in PostgreSQL using Spring Data JPA and Hibernate

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web** — REST endpoints
- **Spring Data JPA** — database access
- **Hibernate** — ORM
- **PostgreSQL** — relational database
- **Maven** — dependency management and build
- **Postman** — API testing

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java (compatible with the version configured in `pom.xml`)
- PostgreSQL
- Git

### 1. Clone the repository

```bash
git clone https://github.com/ElMehdichamam/First-Spring-API.git
cd First-Spring-API
```

### 2. Create the database

Create a PostgreSQL database and a user for the application. For example:

```sql
CREATE USER springuser WITH PASSWORD 'your_password';
CREATE DATABASE springdb OWNER springuser;
```

If you already have `springdb` and `springuser`, you don't need to create them again.

### 3. Configure the application

Open `src/main/resources/application.properties` and configure the database connection:

```properties
spring.application.name=FirstRestApi

spring.datasource.url=jdbc:postgresql://localhost:5432/springdb
spring.datasource.username=springuser
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the database password as an environment variable in your terminal:

```bash
export DB_PASSWORD='your_actual_password'
```

Replace the example password with your actual PostgreSQL user's password. Never commit real credentials to GitHub.

### 4. Run the application

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The API will be available at `http://localhost:8080`.

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Retrieve all tasks |
| GET | `/api/tasks/{id}` | Retrieve a task by ID |
| POST | `/api/tasks` | Create a task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

These routes describe the intended CRUD interface; make sure each endpoint is implemented in `TaskController`.

## Testing with Postman

1. Start the Spring Boot application.
2. Open Postman and create a new HTTP request.
3. Select the HTTP method and enter the endpoint URL.
4. For `POST` and `PUT`, choose **Body → raw → JSON** and provide the task data.
5. Click **Send** and inspect the status code and response body.

Example request body:

```json
{
  "title": "Learn Spring Boot",
  "status": "TODO",
  "dueDate": "2026-10-20"
}
```

The example assumes the `Task` entity uses these field names and the controller accepts this JSON structure.

## What I Learned

- Building REST APIs with Spring Boot
- Using controllers to handle HTTP requests
- Integrating PostgreSQL with Spring Data JPA
- Understanding Hibernate and ORM
- Testing API endpoints with Postman
- Using Git and GitHub to version and publish a project

## Author

**El Mehdi Chamam**

GitHub: [@ElMehdichamam](https://github.com/ElMehdichamam)