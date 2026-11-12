package com.spring.spring_rest.entity;

/**
 * StudentErrorResponse
 */
public class StudentErrorResponse {
    //==========
    // Fields
    //==========
    private int status;
    private String message;
    private Long timeStamp;


    //==========
    // Constructors
    //==========
    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    //==========
    // Setters
    //==========
    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }


    //==========
    // Getters
    //==========
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    
    //==========
    // Methods
    //==========
    @Override
    public String toString() {
        return 
        "StudentErrorResponse [status=" + status +
        ", message=" + message + 
        ", timeStamp=" + timeStamp + "]";
    }
}