package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";

    private static final String USER = "root";

    private static final String PASSWORD = "Neel@0102";
    

    public static Connection getConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (Exception e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();

            return null;
        }
    }
}
