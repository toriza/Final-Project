# PantryPal - Project Documentation

## Table of Contents
1. Introduction
2. Features
3. Technology Stack
4. Configuration
5. Authentication & Authorization
6. Endpoints
7. Exceptions & Error Handling
///8. Class & Use Case Diagrams

---

## 1. Introduction

PantryPal is a web application designed to manage your pantry items, keep track of their quantities, and notify you when items are expired, with potential implementation of notifying when the items are running low and more. The application includes a REST API for managing products, with features such as adding, updating, and deleting pantry items. It also allows users to manage product-specific details such as expiry dates, quantities, and storage locations.

---

## 2. Features

- **CRUD Operations**: Create, Read, Update, and Delete operations for pantry items.
- **Expiry Date Tracking**: Monitors expiry dates for fresh products. The system compares the product's expiration date with the date of the submitted request and notifies the user if the product has expired.
- **Product Categorization**: Supports different product types, such as fresh and dry products, each with specialized fields. For example, DryProducts include categories like *non-edible* for cleaning supplies and *edible* for dry and canned food.
- **User Management**: Users can register and log in.
- **Authorization and Authentication**: Admin and User roles have secure access.

---

## 3. Technology Stack

- **Backend**: Spring Boot
- **Database**: MySQL
- **Authentication**: JWT with Spring Security
- **Version Control**: Git, GitHub
- **API Documentation**: Postman for manual testing

---

## 4. Configuration

- **Database Configuration**: The database connection can be configured in the `application.properties` file under `src/main/resources/`.
    - Set `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password`.

- **JWT Authentication**: JWT tokens are used for secure communication between the frontend and backend. 

---

## 5. Authentication & Authorization

The application supports Role-Based Authentication. The roles are defined as **admin** and **user**, where:

- **Admin**: Full access to all resources, including managing users and products.
- **User**: Limited access to managing only their own products.

---

## 6. Endpoints

- **POST /api/login**: User login
- **POST /api/products**: Add a new product
- **GET /api/products**: Get all products
- **GET /api/products/{id}**: Get a specific product by ID
- **PATCH /api/products/{id}**: Update product details
- **DELETE /api/products/{id}**: Delete a product
- **GET /api/products/fresh**: Get all fresh products
- **GET /api/products/fresh/expired**: Get all fresh products that got expired
- **GET /api/products/dry**: Get all dry products
- **GET /api/products/dry/edible**: Get all dry products that are edible
- **GET /api/products/dry/non-edible**: Get all dry products that are not edible 


## 7. Exceptions & Error Handling
A global exception handler is created using @ControllerAdvice to catch and handle custom exceptions across the application, and return messages, making the API easier to debug and use.

---

//## 8. Diagrams

//### Class Diagram

