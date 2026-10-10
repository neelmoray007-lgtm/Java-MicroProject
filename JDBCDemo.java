package util;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

    public void demonstrateJDBC() {

        System.out.println(
                "\n================================="
        );

        System.out.println(
                "           JDBC DEMO"
        );

        System.out.println(
                "================================="
        );

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            // 1. CONNECTION
            connection =
                    DBConnection.getConnection();

            if (connection == null) {

                System.out.println(
                        "Could not connect to database."
                );

                return;
            }

            System.out.println(
                    "\n1. Connection established."
            );


            // 2. STATEMENT
            System.out.println(
                    "\n2. Using Statement:"
            );

            statement =
                    connection.createStatement();

            resultSet =
                    statement.executeQuery(
                            "SELECT COUNT(*) AS total " +
                            "FROM student"
                    );

            if (resultSet.next()) {

                System.out.println(
                        "Total students: "
                        + resultSet.getInt("total")
                );
            }

            resultSet.close();
            resultSet = null;


            // 3. PREPAREDSTATEMENT
            System.out.println(
                    "\n3. Using PreparedStatement:"
            );

            preparedStatement =
                    connection.prepareStatement(
                            "SELECT * FROM student " +
                            "WHERE id = ?"
                    );

            preparedStatement.setInt(
                    1,
                    101
            );

            resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println(
                        "Student found:"
                );

                System.out.println(
                        "ID     : "
                        + resultSet.getInt("id")
                );

                System.out.println(
                        "Name   : "
                        + resultSet.getString("name")
                );

                System.out.println(
                        "Course : "
                        + resultSet.getString("course")
                );

                System.out.println(
                        "Marks  : "
                        + resultSet.getDouble("marks")
                );

            } else {

                System.out.println(
                        "Student ID 101 not found."
                );
            }

            resultSet.close();
            resultSet = null;

            preparedStatement.close();
            preparedStatement = null;


            // 4. CRUD EXPLANATION
            System.out.println(
                    "\n4. JDBC CRUD Operations:"
            );

            System.out.println(
                    "CREATE/INSERT  -> Add student"
            );

            System.out.println(
                    "READ/SELECT    -> View/search student"
            );

            System.out.println(
                    "UPDATE         -> Modify student"
            );

            System.out.println(
                    "DELETE         -> Remove student"
            );


            System.out.println(
                    "\nJDBC demonstration completed."
            );

        } catch (Exception e) {

            System.out.println(
                    "JDBC demonstration failed!"
            );

            e.printStackTrace();

        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {

                System.out.println(
                        "Error closing JDBC resources."
                );
            }
        }
    }
}
