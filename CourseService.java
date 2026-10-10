package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseService {

    // 1. ADD COURSE
    public void addCourse(int courseId, String courseName,
                          String teacherName, String duration) {

        String sql = "INSERT INTO course "
                   + "(course_id, course_name, teacher_name, duration) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, courseId);
            statement.setString(2, courseName);
            statement.setString(3, teacherName);
            statement.setString(4, duration);

            statement.executeUpdate();

            System.out.println("Course added successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error adding course!");
            e.printStackTrace();
        }
    }


    // 2. VIEW ALL COURSES
    public void viewCourses() {

        String sql = "SELECT * FROM course";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            var resultSet = statement.executeQuery();

            System.out.println("\n===== COURSE LIST =====");

            while (resultSet.next()) {

                System.out.println(
                    "Course ID   : " +
                    resultSet.getInt("course_id")
                );

                System.out.println(
                    "Course Name : " +
                    resultSet.getString("course_name")
                );

                System.out.println(
                    "Teacher     : " +
                    resultSet.getString("teacher_name")
                );

                System.out.println(
                    "Duration    : " +
                    resultSet.getString("duration")
                );

                System.out.println("-------------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error viewing courses!");
            e.printStackTrace();
        }
    }
}

