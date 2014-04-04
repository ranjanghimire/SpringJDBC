package com.hackshaw.ronney.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {
    private static Connection con = null;
    public static Connection getConn() {
        String url = "jdbc:mysql://localhost:3306/user";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class Not Found, " + e);
        } catch (SQLException e) {
            System.out.println(("SQL Exception" + e));
        }
        return con;
    }
}
