package com.spring.spring_rest.exception;

/**
 * Custom runtime exception thrown,
 * when a requested student record cannot be found.
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2690100046087976236L;

    /**
     * Constructs new {@code StudentNotFoundException} with details and cause.
     * 
     * @param message the message explaning the reason for exception.
     * @param cause the underlying cause of exception.
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs new {@code StudentNotFoundException} with detailed message.
     * 
     * @param message the message explaning the reason for exception.
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs new {@code StudentNotFoundException} with cause.
     * 
     * @param cause the underlying cause of exception.
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
