package com.example.adminapp;

public class AdminModel {
    String username;
    String password;


    public AdminModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AdminModel(String username) {
        this.username = username;
    }

    public AdminModel() {
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

}
