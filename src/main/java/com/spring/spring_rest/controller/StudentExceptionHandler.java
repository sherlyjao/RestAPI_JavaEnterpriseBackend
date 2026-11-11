package com.spring.spring_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * StudentExceptionHandler
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(
        StudentNotFoundException ex
    ) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
