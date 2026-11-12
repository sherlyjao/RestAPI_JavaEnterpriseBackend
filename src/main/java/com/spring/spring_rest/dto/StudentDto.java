package com.spring.spring_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * DTO representing student information transferred between,
 * the client and the REST API, 
 * including field-level input validation constraints.
 */
public class StudentDto {
    //==========
    // Fields
    //==========
    private Long id;

    @Size (
        min = 2, 
        max = 50, 
        message = "Must be 2 to 50 characters."
    )
    private String firstName;

    @Size (
        min = 2, 
        max = 50, 
        message = "Must be 2 to 50 characters."
    )
    private String lastName;

    @Email (message = "Email is required and should be valid.")
    private String email;


    //==========
    // Constructors
    //==========
    public StudentDto() {
    }

    public StudentDto(
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
        return 
            "StudentDto [id=" + id + 
            ", firstName=" + firstName + 
            ", lastName=" + lastName + 
            ", email=" + email + "]";
    }
}
