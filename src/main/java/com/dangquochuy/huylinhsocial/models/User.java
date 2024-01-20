package com.dangquochuy.huylinhsocial.models;

import com.dangquochuy.huylinhsocial.controllers.HlBookController;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class User extends ConnectDatabase{
    private static String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addUser(String name, String birthday, String email, String password) throws SQLException {
        Connection conn;
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, date_of_birth, email, password) VALUES (?, ?, ?, ?)")) {
                pstmt.setString(1, name);
                pstmt.setString(2, birthday);
                pstmt.setString(3, email);
                pstmt.setString(4, password);
                pstmt.executeUpdate();
                System.out.println("Register succesfully!");
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean uploadAvatar(int userId, String avatarPath) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            try (PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET avatar = ? WHERE id = ?")) {
                pstmt.setString(1, avatarPath); // Set avatar path at index 1
                pstmt.setInt(2, userId); // Set user ID at index 2

                pstmt.executeUpdate();

                System.out.println("Avatar uploaded successfully!");

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String[]> getAllUser() throws SQLException {
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        List<String[]> userList = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while(rs.next()) {
                String[] user = new String[5];
                user[0] = rs.getString("email");
                user[1] = rs.getString("password");
                user[2] = rs.getString("name");
                user[3] = rs.getString("id");
                user[4] = rs.getString("avatar");
                userList.add(user);
            }
        }
        return userList;
    }

    public boolean validateUser(String email, String password) throws SQLException {
        List<String[]>  userList = getAllUser();
        for(String[] user : userList) {
            if(email.equals(user[0]) && password.equals(user[1])) {
                if(user[4] != null) {
                    new HlBookController().setAvatar(user[4]);
                }
                System.out.println(new HlBookController().getAvatar());
                setName(user[2]);
                System.out.println(getName());
                new HlBookController().setUserId(Integer.parseInt(user[3]));
                System.out.println("User is valid!");
                return true;
            }
        }
        return false;
    }
//    SQL reset users: TRUNCATE TABLE users; ALTER TABLE users AUTO_INCREMENT = 1;

    public static void main(String[] args) throws ParseException, SQLException {
        User user = new User();
        int userId = 11; // Replace with the actual user ID
        String avatarPath = "/path/to/avatar/image.jpg"; // Replace with the actual file path
        user.uploadAvatar(userId, avatarPath);

    }
}


