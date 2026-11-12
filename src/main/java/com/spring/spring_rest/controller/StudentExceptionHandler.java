package com.spring.spring_rest.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Global exception handler for the REST API,
 * intercepting exceptions thrown across,
 * controllers and returning structured HTTP error responses.
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Handles exception when a requested student record does not exist.
     * 
     * @param ex the caught {@link StudentNotFoundException}.
     * @return a {@link ResponseEntity} containing response and status.
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

    /**
     * Handles any uncaught generic {@link Exception} across the application,
     * such as type mismatch errors.
     * 
     * @param the caught {@link StudentNotFoundException}.
     * @return a {@link ResponseEntity} containing response and status.
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(
        Exception ex
    ) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted!");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles exception when request body validation fails.
     *
     * @param the caught {@link StudentNotFoundException}.
     * @return a {@link ResponseEntity} containing response and status.
     */
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
        MethodArgumentNotValidException ex
    ) {

        Map<String, String> err = new HashMap<>();

        //extract every field error and message
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
