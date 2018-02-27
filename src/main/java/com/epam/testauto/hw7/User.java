package com.epam.testauto.hw7;

public class User {

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "Piter Chailovskii");

    private String login;
    private String password;
    private String userName;

    public User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }
}