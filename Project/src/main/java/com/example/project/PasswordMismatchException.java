package com.example.project.Useless;

public class PasswordMismatchException extends Exception {
    private String password;

    public PasswordMismatchException(String password) {
        super("The password " + password + " is incorrect.");
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
