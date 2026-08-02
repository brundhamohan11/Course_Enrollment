CREATE DATABASE course_enrollment;
USE course_enrollment;
CREATE TABLE enrollment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    duration VARCHAR(50),
    status VARCHAR(30)
);
SHOW TABLES;
DESC enrollment;
SELECT * FROM enrollment;
