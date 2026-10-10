package model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String course;
    private double marks;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(int id, String name, String email, String course, double marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student information
    public void displayStudent() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Email  : " + email);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
    }
}

