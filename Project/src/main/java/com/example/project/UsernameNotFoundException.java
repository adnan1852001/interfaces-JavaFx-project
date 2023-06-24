package com.example.project.Useless;

public class UsernameNotFoundException extends Exception {

    private String username;

    public UsernameNotFoundException(String username) {
        super("The user name " + username + " is not found.");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}