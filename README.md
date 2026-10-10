# Student Course & Attendance Management System

## 1. Project Title

Student Course & Attendance Management System using Core Java and JDBC.

---

## 2. Project Description

The Student Course & Attendance Management System is a console-based Java application developed using Core Java, JDBC, and MySQL.

The system allows users to manage student information, courses, attendance records, and student reports.

It also demonstrates important Java programming concepts included in the college syllabus.

---

## 3. Technologies Used

- Java JDK 21
- Core Java
- JDBC
- MySQL
- MySQL Workbench
- VS Code
- MySQL Connector/J

---

## 4. Main Features

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Add Course
7. View Courses
8. Mark Attendance
9. View Attendance
10. Generate Student Report
11. Show Top Students
12. Functional Interface Demo
13. Inheritance and Interface Demo
14. Java Basics Demo
15. Thread and Synchronization Demo
16. Collections Demo
17. JDBC Demo

---

## 5. Database Tables

### Student

Stores student information.

Fields:

- id
- name
- email
- course
- marks

### Course

Stores course information.

Fields:

- course_id
- course_name
- teacher_name
- duration

### Attendance

Stores attendance information.

Fields:

- attendance_id
- student_id
- course_id
- attendance_date
- status

---

## 6. Java Concepts Demonstrated

### Unit 1 - Java Basics

- Classes and Objects
- Constructors
- Constructor Overloading
- Encapsulation
- Data Types
- Type Casting
- StringBuffer
- Wrapper Classes
- Vector
- Static Members
- Garbage Collection

### Unit 2 - Object Oriented Programming

- Inheritance
- Abstract Class
- Interface
- Method Overriding
- final keyword
- Access Modifiers
- Packages
- Import Statements
- Polymorphism

### Unit 3 - Exception Handling and Threads

- try-catch
- finally
- throw
- throws
- Custom Exception
- Thread
- Runnable
- Thread Priority
- sleep()
- join()
- synchronized
- wait()
- notify()
- Inter-thread Communication

### Unit 4 - Java 8 Features and Collections

- Lambda Expressions
- Predicate
- Supplier
- Consumer
- Function
- ArrayList
- LinkedList
- HashSet
- HashMap
- List
- Set
- Map
- Iterator
- forEach
- LocalDate

### Unit 5 - JDBC

- JDBC Connection
- DriverManager
- Connection
- Statement
- PreparedStatement
- ResultSet
- INSERT
- SELECT
- UPDATE
- DELETE
- CRUD Operations

---

## 7. Project Structure

```text
StudentManagementSystem/
│
├── .vscode/
│   └── settings.json
│
├── lib/
│   └── mysql-connector-j-26.7.0.jar
│
├── model/
│   ├── Student.java
│   ├── Course.java
│   ├── Attendance.java
│   ├── User.java
│   ├── StudentUser.java
│   ├── AdminUser.java
│   └── Reportable.java
│
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   └── AttendanceService.java
│
├── database/
│   └── DBConnection.java
│
├── util/
│   ├── ReportUtil.java
│   ├── FunctionalDemo.java
│   ├── UserDemo.java
│   ├── JavaBasicsDemo.java
│   ├── ThreadDemo.java
│   ├── CollectionDemo.java
│   └── JDBCDemo.java
│
├── exception/
│   └── InvalidMarksException.java
│
├── Main.java
├── database.sql
└── README.md

