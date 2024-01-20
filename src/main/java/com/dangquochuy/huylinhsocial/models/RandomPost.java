package com.dangquochuy.huylinhsocial.models;

import java.sql.SQLException;
import java.util.List;

public class RandomPost extends ConnectDatabase{
    public String[] getRandomPost() throws SQLException {
        List<String[]> post = new  Post().getUserPost();
        int numberPostRandom = (int) (Math.random() * post.size());
        String[] randomPost = post.get(numberPostRandom);

        return randomPost;
    }

    public int getQuantityPostUser() throws SQLException {
        List<String[]> post = new  Post().getUserPost();
        int qty = post.size();
        return qty;
    }

    public static void main(String[] args) throws SQLException {
//        new Post().PrintPost();
        String[] post = new  RandomPost().getRandomPost();
//        System.out.println(post.size());
        System.out.println("---------------------------------");

        for (int i = 0; i < post.length; i++) {
            System.out.println(post[i]);
        }
        System.out.println("---------------------------------");
//        System.out.println((int) (Math.random() * post.size()));
    }
}
