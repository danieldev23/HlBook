package com.dangquochuy.huylinhsocial.models;

import com.dangquochuy.huylinhsocial.controllers.HlBookController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Post extends ConnectDatabase{
    public boolean addPost(int user_id, String post_content) throws SQLException {
        Connection conn;
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO posts (user_id, post_content,image) VALUES (?, ?, ?)")) {
                pstmt.setInt(1, user_id);
                pstmt.setString(2, post_content);
                pstmt.setString(3, null);
                pstmt.executeUpdate();
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPostImg(int user_id, String post_content, String img) throws SQLException {
        Connection conn;
        try {
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO posts (user_id, post_content,image) VALUES (?, ?, ?)")) {
                pstmt.setInt(1, user_id);
                pstmt.setString(2, post_content);
                pstmt.setString(3, img);
                pstmt.executeUpdate();
                System.out.println("Posted successfully");
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String[]> getAllPost() throws SQLException {
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        List<String[]> listPost = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM posts")) {
            while(rs.next()) {
                String[] post = new String[4];
                post[0] = rs.getString("id");
                post[1] = rs.getString("user_id");
                post[2] = rs.getString("post_content");
                post[3] = rs.getString("image");
                listPost.add(post);
            }
        }
        return listPost;
    }

    public boolean deletePostById(int postId) throws SQLException {
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM posts WHERE id = ?")) {
            pstmt.setInt(1, postId);
            int affectedRows = pstmt.executeUpdate();
            conn.close();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editPostById(int postId, String newContent, String newImage) throws SQLException {
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE posts SET post_content = ?, image = ? WHERE id = ?")) {
            pstmt.setString(1, newContent);
            pstmt.setString(2, newImage);
            pstmt.setInt(3, postId);

            int affectedRows = pstmt.executeUpdate();
            conn.close();

//            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> getUserPost() throws SQLException {
        List<String[]>  listPost = getAllPost();
        List<String[]> userPost = new ArrayList<>();
        for(String[] post : listPost) {
            if(Integer.parseInt(post[1]) == new HlBookController().getUserId()) {
//            if(Integer.parseInt(post[1]) == 1) {

               String[] p = new String[4];
               p[0] = post[0];
               p[1] = post[1];
               p[2] = post[2];
               p[3] = post[3];
                userPost.add(p);
            }
        }

        return userPost;
    }
    public void PrintPost() throws SQLException {
        List<String[]> pUser = getUserPost();
        for (String[] a : pUser) {
            for (int i = 0; i < a.length; i++) {

                System.out.println(a[i]);
            }
        }
    }
    //    SQL reset posts: TRUNCATE TABLE posts; ALTER TABLE posts AUTO_INCREMENT = 1;
    public static void main(String[] args) throws SQLException {
        int postIdToDelete = 1;
        boolean result = new Post().deletePostById(postIdToDelete);

        if (result) {
            System.out.println("Post deleted successfully.");
        } else {
            System.out.println("Failed to delete post. Post with ID " + postIdToDelete + " not found.");
        }

        // In danh sách bài viết sau khi xoá
        new Post().PrintPost();

    }
}
