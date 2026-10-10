package model;

import java.time.LocalDate;

public class Attendance {

    private int attendanceId;
    private int studentId;
    private int courseId;
    private LocalDate attendanceDate;
    private String status;

    // Default constructor
    public Attendance() {
    }

    // Parameterized constructor
    public Attendance(int attendanceId, int studentId,
                      int courseId, LocalDate attendanceDate,
                      String status) {

        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Getters
    public int getAttendanceId() {
        return attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display attendance
    public void displayAttendance() {

        System.out.println(
            "Attendance ID : " + attendanceId
        );

        System.out.println(
            "Student ID    : " + studentId
        );

        System.out.println(
            "Course ID     : " + courseId
        );

        System.out.println(
            "Date          : " + attendanceDate
        );

        System.out.println(
            "Status        : " + status
        );
    }
}
