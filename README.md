# Dynamic E-commerce Walkthrough

I have successfully developed the dynamic Spring Boot e-commerce platform according to your requirements!

## Changes Made

### 1. Configuration & Project Setup
- Configured a new Spring Boot application (`dynamic-ecommerce`).
- Set up **Maven** dependencies for Spring Web, Spring Security, Spring Data JPA, Thymeleaf, and H2 database.
- Configured `application.properties` to use **port 9090** as requested.
- Set up an in-memory **H2 Database** for quick testing and dynamic data manipulation.

### 2. Security and Access Control
- Implemented `SecurityConfig` with robust role-based access control (RBAC).
- Created two roles: `USER` and `ADMIN`.
- Built a unified login system that smartly redirects users based on their role:
  - `ADMIN` is securely redirected to the **backend admin dashboard** (`/admin/dashboard`).
  - `USER` is redirected to the **frontend shop interface** (`/`).
- Set up a `DataInitializer` component that automatically injects two sample accounts into the database upon application startup:
  - Admin: `admin` / `admin123`
  - User: `user` / `user123`

### 3. User Interface (UI)
- Developed a **Premium Vanilla CSS** style system (`style.css`) with modern aesthetics: glassmorphism effects, modern typography (`Inter`), clean spacing, and smooth hover animations.
- Created `login.html`: A beautiful, centralized authentication page.
- Created `index.html`: The frontend view for regular users to browse products.
- Created `admin/dashboard.html`: The backend control panel displaying key administrative metrics.

## Validation Results

- The application was built successfully using the Maven wrapper.
- The server started successfully on **port 9090**.
- The `DataInitializer` executed and successfully seeded the `users` table with the sample credentials.

## How to Test

You can access the application right now!

1. Open your web browser and navigate to: **`http://localhost:9090`**
2. You will be redirected to the secure login screen.
3. Try logging in as a **User** (Frontend Access):
   - **Username**: `user`
   - **Password**: `user123`
4. Sign out, and try logging in as an **Admin** (Backend Access):
   - **Username**: `admin`
   - **Password**: `admin123`

Enjoy your new dynamic e-commerce platform!