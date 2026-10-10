package model;

public class Course {

    private int courseId;
    private String courseName;
    private String teacherName;
    private String duration;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(int courseId, String courseName,
                  String teacherName, String duration) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.duration = duration;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDuration() {
        return duration;
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    // Display course
    public void displayCourse() {

        System.out.println("Course ID     : " + courseId);
        System.out.println("Course Name   : " + courseName);
        System.out.println("Teacher       : " + teacherName);
        System.out.println("Duration      : " + duration);
    }
}
