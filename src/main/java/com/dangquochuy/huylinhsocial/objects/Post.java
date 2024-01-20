package com.dangquochuy.huylinhsocial.objects;

public class Post {
    private Account account;
    private PostAudience audience;
    private String date;
    private String caption;
    private String image;
    private int totalReactions;
    private int hlComments;
    private int hlShares;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PostAudience getAudience() {
        return audience;
    }

    public void setAudience(PostAudience audience) {
        this.audience = audience;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalReactions() {
        return totalReactions;
    }

    public void setTotalReactions(int totalReactions) {
        this.totalReactions = totalReactions;
    }

    public int getHlComments() {
        return hlComments;
    }

    public void setHlComments(int nbComments) {
        this.hlComments = hlComments;
    }

    public int getHlShares() {
        return hlShares;
    }

    public void setHlShares(int nbShares) {
        this.hlShares = hlShares;
    }
}