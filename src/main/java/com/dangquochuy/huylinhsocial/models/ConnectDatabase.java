package com.dangquochuy.huylinhsocial.models;
import java.sql.*;
import java.text.ParseException;

public class ConnectDatabase {
    public static String DB_URL = "jdbc:mysql://localhost:3306/db_final";
    public static String USER_NAME = "root";
    public static String PASSWORD = "";

    public static void main(String args[]) throws ParseException, SQLException {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
