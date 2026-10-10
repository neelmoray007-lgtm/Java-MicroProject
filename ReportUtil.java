package util;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportUtil {

    public void generateStudentReport(int studentId) {

        String studentSql =
                "SELECT * FROM student WHERE id = ?";

        String attendanceSql =
                "SELECT COUNT(*) AS total, " +
                "SUM(CASE WHEN status = 'Present' THEN 1 ELSE 0 END) " +
                "AS present " +
                "FROM attendance WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            // Get student details
            PreparedStatement studentStatement =
                    connection.prepareStatement(studentSql);

            studentStatement.setInt(1, studentId);

            ResultSet studentResult =
                    studentStatement.executeQuery();

            if (!studentResult.next()) {

                System.out.println("Student not found!");

                studentResult.close();
                studentStatement.close();
                connection.close();

                return;
            }

            System.out.println("\n=================================");
            System.out.println("        STUDENT REPORT");
            System.out.println("=================================");

            System.out.println(
                "Student ID : " +
                studentResult.getInt("id")
            );

            System.out.println(
                "Name       : " +
                studentResult.getString("name")
            );

            System.out.println(
                "Email      : " +
                studentResult.getString("email")
            );

            System.out.println(
                "Course     : " +
                studentResult.getString("course")
            );

            System.out.println(
                "Marks      : " +
                studentResult.getDouble("marks")
            );

            studentResult.close();
            studentStatement.close();


            // Get attendance details
            PreparedStatement attendanceStatement =
                    connection.prepareStatement(attendanceSql);

            attendanceStatement.setInt(1, studentId);

            ResultSet attendanceResult =
                    attendanceStatement.executeQuery();

            if (attendanceResult.next()) {

                int total =
                    attendanceResult.getInt("total");

                int present =
                    attendanceResult.getInt("present");

                double percentage = 0;

                if (total > 0) {
                    percentage =
                        (present * 100.0) / total;
                }

                System.out.println(
                    "Total Classes : " + total
                );

                System.out.println(
                    "Present       : " + present
                );

                System.out.println(
                    "Attendance    : " +
                    String.format("%.2f", percentage) +
                    "%"
                );
            }

            System.out.println("=================================");

            attendanceResult.close();
            attendanceStatement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                "Error generating student report!"
            );

            e.printStackTrace();
        }
    }
}
