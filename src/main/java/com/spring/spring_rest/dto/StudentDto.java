package com.spring.spring_rest.dto;

/**
 * StudentDto
 */
public class StudentDto {
    //==========
    // Fields
    //==========
    private Long id;
    private String firstName;
    private String lastName;
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
