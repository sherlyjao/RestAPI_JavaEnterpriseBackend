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
    private long timeStamp;


    //==========
    // Constructors
    //==========
    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
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

    public long getTimeStamp() {
        return timeStamp;
    }
}