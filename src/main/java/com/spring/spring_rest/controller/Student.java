package com.spring.spring_rest.controller;

/**
 * Student
 */
public class Student {
    //==========
    // Fields
    //==========
    private String firstName;
    private String lastName;


    //==========
    // Constructor
    //==========
    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //==========
    // Setters
    //==========
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //==========
    // Getters
    //==========
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
