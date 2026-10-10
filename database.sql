CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;


-- =========================================
-- STUDENT TABLE
-- =========================================

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    course VARCHAR(100),
    marks DOUBLE
);


-- =========================================
-- COURSE TABLE
-- =========================================

CREATE TABLE IF NOT EXISTS course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    teacher_name VARCHAR(100),
    duration VARCHAR(50)
);


-- =========================================
-- ATTENDANCE TABLE
-- =========================================

CREATE TABLE IF NOT EXISTS attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL
);


-- =========================================
-- SAMPLE STUDENTS
-- =========================================

INSERT IGNORE INTO student
(id, name, email, course, marks)
VALUES
(101, 'Aditya wagh', 'aditya@gmail.com', 'Java', 85),
(102, 'Krishna Patil', 'krishna8040@gmail.com', 'Database', 72),
(103, 'Aryaman Joshi', 'aryu7444@gmail.com', 'Java', 92);


-- =========================================
-- SAMPLE COURSES
-- =========================================

INSERT IGNORE INTO course
(course_id, course_name, teacher_name, duration)
VALUES
(1, 'Java Programming', 'Dr. Sharma', '6 Months'),
(2, 'Database Management', 'Prof. Verma', '6 Months');
(3, 'Operating System', ' Prof.Vilas Rathod','6 Month');



-- =========================================
-- SAMPLE ATTENDANCE
-- =========================================

INSERT INTO attendance
(student_id, course_id, attendance_date, status)
VALUES
(101, 1, '2026-10-01', 'Present'),
(101, 1, '2026-10-02', 'Present'),
(101, 1, '2026-10-03', 'Absent'),
(102, 2, '2026-10-01', 'Present'),
(102, 2, '2026-10-02', 'Absent'),
(103, 1, '2026-10-01', 'Present'),
(103, 1, '2026-10-02', 'Present');
