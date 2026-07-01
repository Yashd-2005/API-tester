# API Testing Tool

A lightweight API Testing Tool built using **Java**, **Spring Boot**, and **Java HttpClient** that enables users to send HTTP requests to REST APIs and inspect the responses through a simple web interface.

---

## Features

- Supports HTTP Methods
  - GET
  - POST
  - PUT
  - DELETE

- Custom Request Headers
- JSON Request Body Support
- Displays Response Status Code
- Displays Response Headers
- Displays Response Body
- Measures API Response Time
- Clean Layered Architecture

---

## Tech Stack

### Backend
- Java 21
- Spring Boot
- Java HttpClient
- Maven

### Frontend
- HTML
- CSS
- JavaScript

---

## Project Structure

```
src
├── controller
│      ApiController
│
├── service
│      ApiService
│
├── dto
│      ApiRequest
│      ApiResponse
│
└── resources
       └── static
            index.html
            style.css
            script.js
```

---

## Architecture

```
Frontend (HTML/CSS/JS)
        │
        ▼
Spring Boot Controller
        │
        ▼
Service Layer
        │
        ▼
Java HttpClient
        │
        ▼
Target REST API
```

---

## How It Works

1. Select the HTTP method.
2. Enter the target API URL.
3. Add request headers (JSON format).
4. Enter the request body (for POST/PUT).
5. Click **Send Request**.
6. The backend constructs an HTTP request using Java HttpClient.
7. The target API processes the request.
8. The response is returned and displayed with:
   - Status Code
   - Response Time
   - Response Headers
   - Response Body

---

## Example Request

### GET

```
Method : GET

URL :
https://jsonplaceholder.typicode.com/posts/1
```

### POST

Headers

```json
{
  "Content-Type":"application/json"
}
```

Body

```json
{
  "title":"API Tester",
  "body":"Testing POST Request",
  "userId":1
}
```

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/Yashd-2005/API-Testing-Tool.git
```

### Navigate

```bash
cd API-Testing-Tool
```

### Run

```bash
mvn spring-boot:run
```

Application will start at

```
http://localhost:8080
```

---

## Future Enhancements

- Dynamic Header Builder
- Query Parameter Builder
- Pretty JSON Formatting
- Request History
- Save API Collections
- Authentication Support (JWT/Bearer Token)
- Import & Export Requests

---

## Learning Outcomes

This project demonstrates:

- REST API Communication
- HTTP Methods
- Java HttpClient
- Spring Boot Backend Development
- Layered Architecture
- JSON Processing
- Request & Response Handling

---

## Author

**Yash Dayalwar**

- LinkedIn: https://linkedin.com/in/yashdayalwar
- GitHub: https://github.com/Yashd-2005
