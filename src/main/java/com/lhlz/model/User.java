package com.lhlz.model;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String user_created_at;

    public User() {
    }

    public User(int user_id, String username, String password, String user_created_at) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_created_at = user_created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_created_at() {
        return user_created_at;
    }

    public void setUser_created_at(String user_created_at) {
        this.user_created_at = user_created_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
