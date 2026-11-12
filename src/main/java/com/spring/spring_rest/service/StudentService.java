package com.spring.spring_rest.service;

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
}
