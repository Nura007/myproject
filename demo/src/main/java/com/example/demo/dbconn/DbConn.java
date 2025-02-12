package com.example.demo.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nura2007" ;

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Подключение к базе данных успешно!");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}
