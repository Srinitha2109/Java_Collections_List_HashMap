package org.example.phoneDbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public static  Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/phone_db";
        String username = "root";
        String password = "sql@1234";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return connection;
    }


}
