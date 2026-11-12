package com.spring.spring_rest.service;

import java.util.List;
import com.spring.spring_rest.dto.StudentDto;

/**
 * Interface StudentService defining business operations.
 * Manages {@link StudentDto} records.
 */
public interface StudentService {

    /**
     * Creates and persists new student record.
     * 
     * @param theStudentDto data transfer object containing the student deets.
     * @return the saved {@link StudentDto}
     */
    StudentDto createStudent(StudentDto theStudentDto);

    /**
     * Retrieves specific student record by ID.
     * 
     * @param theId the id of student to retrieve.
     * @return the {@link StudentDto} matching the ID.
     */
    StudentDto getStudentById(Long theId);

    /**
     * Retrieves all existing student records.
     * 
     * @return a List of all {@link StudentDto} objects.
     */
    List<StudentDto> getAllStudents();

    /**
     * Replacing and existing student record with updated details.
     * 
     * @param theId the ID of student to be updated.
     * @param theStudentDto data transfer object containing the student deets.
     * @return the updated {@link StudentDto}
     */
    StudentDto updateStudent(Long theId, StudentDto theStudentDto);

    /**
     * Partially updates existing student record.
     * Can accept null fields from param DTO.
     * 
     * @param theId the ID of student to be updated.
     * @param theStudentDto data transfer object containing the student deets.
     * @return the updated {@link StudentDto}
     */
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);

    /**
     * Deletes a specific student record by ID.
     * 
     * @param theId the ID of student to be deleted.
     */
    void deleteStudentById(Long theId);
}
