package service;

import database.DBConnection;
import exception.InvalidMarksException;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // 1. ADD STUDENT
    public void addStudent(int id, String name, String email,
                           String course, double marks) {

        try {

            validateMarks(marks);

            String sql =
                    "INSERT INTO student " +
                    "(id, name, email, course, marks) " +
                    "VALUES (?, ?, ?, ?, ?)";

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, course);
            statement.setDouble(5, marks);

            statement.executeUpdate();

            System.out.println(
                    "Student added successfully!"
            );

            statement.close();
            connection.close();

        } catch (InvalidMarksException e) {

            System.out.println(
                    "Invalid marks: " + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error adding student!"
            );

            e.printStackTrace();
        }
    }


    // 2. VIEW ALL STUDENTS
    public void viewStudents() {

        String sql = "SELECT * FROM student";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery();

            System.out.println(
                    "\n===== STUDENT LIST ====="
            );

            while (resultSet.next()) {

                System.out.println(
                        "ID     : " +
                        resultSet.getInt("id")
                );

                System.out.println(
                        "Name   : " +
                        resultSet.getString("name")
                );

                System.out.println(
                        "Email  : " +
                        resultSet.getString("email")
                );

                System.out.println(
                        "Course : " +
                        resultSet.getString("course")
                );

                System.out.println(
                        "Marks  : " +
                        resultSet.getDouble("marks")
                );

                System.out.println(
                        "-------------------------"
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Error viewing students!"
            );

            e.printStackTrace();
        }
    }


    // 3. SEARCH STUDENT
    public void searchStudent(int id) {

        String sql =
                "SELECT * FROM student WHERE id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                System.out.println(
                        "\n===== STUDENT FOUND ====="
                );

                System.out.println(
                        "ID     : " +
                        resultSet.getInt("id")
                );

                System.out.println(
                        "Name   : " +
                        resultSet.getString("name")
                );

                System.out.println(
                        "Email  : " +
                        resultSet.getString("email")
                );

                System.out.println(
                        "Course : " +
                        resultSet.getString("course")
                );

                System.out.println(
                        "Marks  : " +
                        resultSet.getDouble("marks")
                );

            } else {

                System.out.println(
                        "Student not found!"
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Error searching student!"
            );

            e.printStackTrace();
        }
    }


    // 4. UPDATE STUDENT
    public void updateStudent(int id, String name, String email,
                              String course, double marks) {

        try {

            validateMarks(marks);

            String sql =
                    "UPDATE student SET " +
                    "name = ?, email = ?, " +
                    "course = ?, marks = ? " +
                    "WHERE id = ?";

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, course);
            statement.setDouble(4, marks);
            statement.setInt(5, id);

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Student updated successfully!"
                );

            } else {

                System.out.println(
                        "Student not found!"
                );
            }

            statement.close();
            connection.close();

        } catch (InvalidMarksException e) {

            System.out.println(
                    "Invalid marks: " + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error updating student!"
            );

            e.printStackTrace();
        }
    }


    // 5. DELETE STUDENT
    public void deleteStudent(int id) {

        String sql =
                "DELETE FROM student WHERE id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Student deleted successfully!"
                );

            } else {

                System.out.println(
                        "Student not found!"
                );
            }

            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Error deleting student!"
            );

            e.printStackTrace();
        }
    }


    // 6. SHOW TOP STUDENTS
    public void showTopStudents() {

        String sql =
                "SELECT * FROM student";

        List<Student> students =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery();

            while (resultSet.next()) {

                Student student =
                        new Student(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("course"),
                                resultSet.getDouble("marks")
                        );

                students.add(student);
            }

            students.sort(
                    (student1, student2) ->
                            Double.compare(
                                    student2.getMarks(),
                                    student1.getMarks()
                            )
            );

            System.out.println(
                    "\n===== TOP STUDENTS ====="
            );

            int count = 0;

            for (Student student : students) {

                System.out.println(
                        "ID     : " +
                        student.getId()
                );

                System.out.println(
                        "Name   : " +
                        student.getName()
                );

                System.out.println(
                        "Course : " +
                        student.getCourse()
                );

                System.out.println(
                        "Marks  : " +
                        student.getMarks()
                );

                System.out.println(
                        "-------------------------"
                );

                count++;

                if (count == 3) {
                    break;
                }
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "Error showing top students!"
            );

            e.printStackTrace();
        }
    }


    // 7. VALIDATE MARKS
    private void validateMarks(double marks)
            throws InvalidMarksException {

        if (marks < 0 || marks > 100) {

            throw new InvalidMarksException(
                    "Marks must be between 0 and 100."
            );
        }
    }
}


