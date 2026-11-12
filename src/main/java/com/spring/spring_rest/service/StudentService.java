package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

/**
 * StudentService
 */
public interface StudentService {

    /**
     * @param theStudentDto
     * @return
     */
    StudentDto createStudent(StudentDto theStudentDto);

    /**
     * 
     * @param theId
     * @return
     */
    StudentDto getStudentById(Long theId);

    /**
     * 
     * @return
     */
    List<StudentDto> getAllStudents();
}
