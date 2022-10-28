package com.hieucodeg.model;

public class User {
    private String account;
    private String password;
    private String name;
    private String email;
    private int age;

    public User() {
    }

    public User(String account, String password, String name, String email, int age) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
