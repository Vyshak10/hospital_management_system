# hospital_management_system
This is a simple hospital management system built in Java. It is a console-based application that allows users to manage patients, doctors, and appointments. The system connects to a MySQL database to store and retrieve data.

Features
Patient Management:
Add new patients to the system.
View a list of all patients.
Doctor Management:
View a list of all doctors and their specializations.
Appointment Scheduling:
Book appointments for patients with specific doctors on a given date.
Check for doctor availability before booking.
Technologies Used
Java: The core programming language for the application.
JDBC (Java Database Connectivity): Used to connect and interact with the MySQL database.
MySQL: The relational database used to store patient, doctor, and appointment data.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
MySQL Server
An IDE like IntelliJ IDEA or Eclipse (optional, but recommended)
Database Setup
Make sure you have MySQL installed and running.

Create a new database named hospital.

Create the following tables in the hospital database:

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    gender VARCHAR(50)
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255)
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
Optionally, you can insert some sample data into the doctors table:

INSERT INTO doctors (name, specialization) VALUES
('Dr. Smith', 'Cardiology'),
('Dr. Jones', 'Neurology'),
('Dr. Williams', 'Pediatrics');
Configuration
Open the src/HospitalManagementSystem/HospitalManagementSystem.java file.
Update the database connection details (URL, username, and password) to match your MySQL setup:
private static final String url = "jdbc:mysql://localhost:3306/hospital";
private static final String username = "your_mysql_username";
private static final String password = "your_mysql_password";
Running the Application
Compile and run the HospitalManagementSystem.java file.
The application will start in the console, presenting a menu with options to add patients, view patients, view doctors, and book appointments.
