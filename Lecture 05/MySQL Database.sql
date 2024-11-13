CREATE DATABASE mydatabase;
USE mydatabase;

CREATE TABLE employees(
id INT PRIMARY KEY,
name VARCHAR(255),
job_title VARCHAR(255),
salary DOUBLE
);

INSERT INTO employees(id,name,job_title,salary) VALUES 
(1,"Kunal","Software Developer",75000.0),
(2,"Hemant","Devops Engineer",65000.0);