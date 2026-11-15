package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ecommerce_pipeline";

    private static final String USER = "root";

    private static final String PASSWORD = "qwerty";

    public static Connection getConnection() {

        try {

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to MySQL Successfully!");

            return connection;

        } catch (SQLException e) {

            throw new RuntimeException("Database Connection Failed", e);

        }

    }

}