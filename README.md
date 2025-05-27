# Spring Boot Course Management System

This is a backend system for managing courses, mentors, students, and enrolments built with Spring Boot, Spring Data JPA, and Hibernate. It provides RESTful APIs for CRUD operations and business logic associated with educational course enrolments.

## 📂 Project Structure

```
.
├── .mvn/
│   └── wrapper/
├── src/
│   └── main/
│       ├── java/
│       │   └── users.rishik.spring_demo/
│       │       ├── Controllers/
│       │       ├── dto/
│       │       ├── entities/
│       │       ├── enums/
│       │       ├── exceptions/
│       │       ├── mappers/
│       │       ├── projections/
│       │       ├── repositories/
│       │       ├── services/
│       │       └── SpringDemoApplication.java
│       └── resources/
│           └── application.properties
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 🚀 Technologies Used

- **Spring Boot**: Framework for developing RESTful services.
- **Spring Data JPA**: ORM layer for database interactions.
- **Hibernate**: JPA implementation.
- **Lombok**: Reduces boilerplate code.
- **H2 / MySQL (configurable)**: Database engine.
- **Jakarta Validation**: For input validation.
- **Maven**: Build tool.

## 📦 Features

- Add, update, delete, and fetch:
  - **Students**
  - **Mentors**
  - **Courses**
  - **Enrolments**
- **Validation checks** for course capacity and enrolment dates.
- Custom exceptions like `NotFoundException`, `InvalidDateException`, and `MaxCapacityException`.
- Projection-based APIs to optimize data transfer.

## 🧪 API Endpoints

### 🔹 Course APIs

- `POST /courses/add` – Add a single course.
- `POST /courses/addAll` – Add multiple courses.
- `GET /courses/find/{courseId}` – Get course by ID.
- `GET /courses/mentor/{mentorId}` – Get courses by mentor.
- `GET /courses/find/all` – Get all courses.
- `PUT /courses/update/{courseId}` – Update a course.
- `DELETE /courses/delete/{courseId}` – Delete a course.

### 🔹 Mentor APIs

- `POST /mentor/add`
- `POST /mentor/addAll`
- `GET /mentor/find/{mentorId}`
- `GET /mentor/find/all`
- `PUT /mentor/update/{mentorId}`
- `DELETE /mentor/delete/{mentorId}`

### 🔹 Student APIs

- `POST /student/add`
- `POST /student/addAll`
- `GET /student/find/{sid}`
- `GET /student/find/all`
- `PUT /student/update/{studentId}`
- `DELETE /student/delete/{studentId}`

### 🔹 Enrolment APIs

- `POST /enrolment/add`
- `POST /enrolment/addAll`
- `GET /enrolment/find/{enrolmentId}`
- `GET /enrolment/findByCourse/{courseId}`
- `GET /enrolment/findByStudent/{studentId}`
- `GET /enrolment/findByStatus/{status}` (ACTIVE, CANCELLED, COMPLETE)
- `PUT /enrolment/update/{enrolmentId}/status`
- `DELETE /enrolment/delete/{enrolmentId}`

## ⚙️ Project Configuration

### `pom.xml`
Defines project metadata, Java version, and dependencies including:
- Spring Boot starters (Web, JPA)
- Lombok
- H2 / MySQL Connector
- Validation API

### `.gitignore`
Specifies intentionally untracked files to ignore (e.g., `target/`, `.idea/`, `.env`).

### `mvnw` / `mvnw.cmd`
Maven Wrapper scripts to build the project without requiring Maven pre-installed.

### `application.properties`
Configuration file typically used to define database URL, credentials, Hibernate DDL settings, server port, etc.

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/course_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL or H2 (or any supported RDBMS)

### Setup

1. Clone the repository:

```bash
git clone https://github.com/Risspecct/Spring-Course-Management-System.git
cd spring-course-management
```

2. Configure `application.properties` with your database settings.

3. Run the application:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## 🧪 Testing the API

You can use tools like:

- [Postman](https://www.postman.com/)
- [Swagger UI](https://swagger.io/tools/swagger-ui/) (optional setup)
- `curl` via CLI

## 📌 Notes

- Data validation is implemented using Jakarta Bean Validation.
- End date for courses is automatically calculated based on the start date and number of days.
- Mentor and Student relations are enforced via foreign key constraints.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.