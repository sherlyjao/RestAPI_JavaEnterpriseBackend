package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * Utility mapper class responsible for converting data.
 * Converts data from Student entity to StudentDto data transfer object.
 */
public class StudentMapper {

    /**
     * Converts a Student entity into a StudentDto data transfer object.
     * 
     * @param theStudent the {@link Student} entity to convert.
     * @return the converted {@link StudentDto} containing the student deets.
     */
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto(
            theStudent.getId(),
            theStudent.getFirstName(),
            theStudent.getLastName(),
            theStudent.getEmail()
        );
    }

    /**
     * Converts a StudentDto data transfer object into a Student entity.
     * 
     * @param theStudentDto the {@link StudentDto} object to convert.
     * @return the converted {@link Student} containing the student deets.
     */
    public static Student mapToStudent(StudentDto theStudentDto) {
        return new Student(
            theStudentDto.getId(),
            theStudentDto.getFirstName(),
            theStudentDto.getLastName(),
            theStudentDto.getEmail()
        );
    }
}
