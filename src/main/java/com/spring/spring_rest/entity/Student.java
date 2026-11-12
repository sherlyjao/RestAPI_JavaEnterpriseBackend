package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * JPA entity class representing a student record mapped to a database table.
 */
@Entity 
public class Student {
    //==========
    // Fields
    //==========
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column (nullable = false, unique = true)
    private String email;


    //==========
    // Constructors
    //==========
    public Student() {
    }

    public Student(
        Long id, 
        String firstName, 
        String lastName, 
        String email
    ) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    

    //==========
    // Setters
    //==========
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //==========
    // Getters
    //==========
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    //==========
    // Methods
    //==========
    @Override
    public String toString() {
        return "Student [id=" + id +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", email=" + email + "]";
    }
}
