# Course_Enrollment
# Course Enrollment System

A simple Java JDBC console application for managing student course enrollments. The application performs CRUD (Create, Read, Update, Delete) operations using a MySQL database.

## Technologies Used
- Java
- JDBC
- MySQL
- VS Code

## Features
- Add Student
- View Students
- Update Student Status
- Delete Student
- Search Student by Course

## Database
Database Name: `course_enrollment`

Table Name: `enrollment`

## Project Structure

```
src/
├── Main.java
├── CourseEnrollment.java
└── DBConnection.java
```

## How to Run

1. Create the MySQL database and table.
2. Update the database username and password in `DBConnection.java`.
3. Add the MySQL Connector/J JAR to your project.
4. Compile and run `Main.java`.

## Sample Menu

```
===== COURSE ENROLLMENT SYSTEM =====

1. Add Student
2. View Students
3. Update Status
4. Delete Student
5. Search by Course
6. Exit
```
