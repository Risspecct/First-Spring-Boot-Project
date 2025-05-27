# Spring Boot Course Management System

This is a backend system for managing courses, mentors, students, and enrolments built with Spring Boot, Spring Data JPA, and Hibernate. It provides RESTful APIs for CRUD operations and business logic associated with educational course enrolments.

## 📂 Project Structure

```
src/
└── main/
    ├── java/
    │   └── users.rishik.spring_demo/
    │       ├── Controllers/
    │       ├── dto/
    │       ├── entities/
    │       ├── enums/
    │       ├── exceptions/
    │       ├── mappers/
    │       ├── projections/
    │       ├── repositories/
    │       ├── services/
    │       └── SpringDemoApplication.java
    └── resources/
        └── application.properties
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

### 🔹 Miscellaneous

- `GET /add_numbers?a=1&b=2`
- `GET /mul_numbers?a=3&b=4`

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL or H2 (or any supported RDBMS)

### Setup

1. Clone the repository:

```bash
git clone https://github.com/your-username/spring-course-management.git
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