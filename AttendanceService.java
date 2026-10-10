package service;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AttendanceService {

    // 1. MARK ATTENDANCE
    public void markAttendance(int studentId, int courseId,
                               LocalDate attendanceDate,
                               String status) {

        try {

            validateStatus(status);

            String sql =
                    "INSERT INTO attendance " +
                    "(student_id, course_id, attendance_date, status) " +
                    "VALUES (?, ?, ?, ?)";

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);

            statement.setDate(
                    3,
                    java.sql.Date.valueOf(attendanceDate)
            );

            statement.setString(
                    4,
                    status
            );

            statement.executeUpdate();

            System.out.println(
                    "Attendance marked successfully!"
            );

            statement.close();
            connection.close();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Invalid attendance data: " +
                    e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error marking attendance!"
            );

            e.printStackTrace();

        } finally {

            System.out.println(
                    "Attendance operation completed."
            );
        }
    }


    // 2. VIEW ATTENDANCE
    public void viewAttendance() {

        String sql =
                "SELECT * FROM attendance";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            var resultSet =
                    statement.executeQuery();

            System.out.println(
                    "\n===== ATTENDANCE RECORDS ====="
            );

            while (resultSet.next()) {

                System.out.println(
                        "Attendance ID : " +
                        resultSet.getInt(
                                "attendance_id"
                        )
                );

                System.out.println(
                        "Student ID    : " +
                        resultSet.getInt(
                                "student_id"
                        )
                );

                System.out.println(
                        "Course ID     : " +
                        resultSet.getInt(
                                "course_id"
                        )
                );

                System.out.println(
                        "Date          : " +
                        resultSet.getDate(
                                "attendance_date"
                        )
                );

                System.out.println(
                        "Status        : " +
                        resultSet.getString(
                                "status"
                        )
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
                    "Error viewing attendance!"
            );

            e.printStackTrace();

        } finally {

            System.out.println(
                    "Attendance records operation completed."
            );
        }
    }


    // 3. VALIDATE ATTENDANCE STATUS
    private void validateStatus(String status)
            throws IllegalArgumentException {

        if (status == null ||
            (!status.equalsIgnoreCase("Present")
             && !status.equalsIgnoreCase("Absent"))) {

            throw new IllegalArgumentException(
                    "Status must be Present or Absent."
            );
        }
    }


    // 4. PARSE DATE
    public LocalDate parseDate(String date)
            throws DateTimeParseException {

        return LocalDate.parse(date);
    }
}

