package com.example.quizapp;

public class User {
    public int Id;
    public String FirstName,LastName,Email,Password;

    public User(int id, String firstName, String lastName, String email, String password) {
        this.Id = id;

        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
    }
    public User( String firstName, String lastName, String email, String password) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
    }

    public User() {
    }
}
