# 🚆 SmartTrain - Ticket Booking System

SmartTrain is a full-featured **Spring Boot RESTful API** that allows users to register, log in with JWT authentication, and perform **CRUD operations on train bookings**. It includes **role-based access control**, validation, and exception handling.

---

## 📌 Features

- 🔐 **Authentication & Authorization** using Spring Security + JWT
- 👥 Role-based access control (`ADMIN`, `USER`)
- ✅ Register & login functionality
- 🎫 Add, view, update, and delete bookings
- 🚉 Manage train details and schedules (CRUD)
- 📑 Input validation and centralized exception handling
- 🧪 Tested via **Postman**

---

## 🛠️ Tech Stack

| Layer            | Technology                     |
|------------------|--------------------------------|
| Backend          | Java + Spring Boot             |
| Security         | Spring Security + JWT          |
| ORM & DB Access  | Spring Data JPA + Hibernate    |
| Database         | MySQL                          |
| Testing Tool     | Postman                        |
| Build Tool       | Maven                          |
| IDE              | Spring Tool Suite              |

---

## 📂 Project Structure

---

## 🧾 API Endpoints

### 🔑 Authentication

| Method | Endpoint        | Description      |
|--------|------------------|------------------|
| POST   | `/auth/register` | Register a user  |
| POST   | `/auth/login`    | Login and get JWT|

---

### 🎫 Booking (User)

| Method | Endpoint            | Description              |
|--------|----------------------|--------------------------|
| GET    | `/bookings`          | Get all user bookings    |
| POST   | `/bookings`          | Book a train             |
| PUT    | `/bookings/{id}`     | Update a booking         |
| DELETE | `/bookings/{id}`     | Cancel a booking         |

---

### 🚆 Train (Admin)

| Method | Endpoint           | Description         |
|--------|---------------------|---------------------|
| POST   | `/trains`           | Add a train         |
| GET    | `/trains`           | Get all trains      |
| PUT    | `/trains/{id}`      | Update train info   |
| DELETE | `/trains/{id}`      | Delete a train      |

---

## 🛡️ JWT Authentication Flow

1. **Register or Login** → get JWT token.
2. Token must be included in `Authorization` header:  
3. Access is restricted based on role:
- `USER`: can manage own bookings
- `ADMIN`: can manage all trains

---

## 🧪 Postman Collection

You can import the provided Postman collection to test endpoints easily.

---

## 📦 Run Locally



