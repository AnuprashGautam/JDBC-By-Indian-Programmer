CREATE DATABASE hospital;
USE hospital;

CREATE TABLE patients(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(225) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(6) NOT NULL
);

CREATE TABLE doctors(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(225) NOT NULL,
    specialization VARCHAR(255) NOT NULL
);

CREATE TABLE appointment (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

INSERT INTO doctors(name, specialization) VALUES
	("Pankaj Jain", "Physician"),
    ("Harshit Amod", "Neuro Surgeon");
	