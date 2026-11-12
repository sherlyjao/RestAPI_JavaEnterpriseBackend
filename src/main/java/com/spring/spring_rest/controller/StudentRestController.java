package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * StudentRestController
 */
@RestController 
@RequestMapping ("/api")
public class StudentRestController {
    //==========
    // Fields
    //==========
    private List<Student> theStudents;
    private StudentService studentService;


    //==========
    // Constructors
    //==========
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }


    //==========
    // Methods
    //==========
    @PostConstruct 
    public void initialize() {
        theStudents = new ArrayList<>();

        String[][] studentData = {
            {"Harry James", "Potter"},
            {"Hermione", "Granger"},
            {"Ronald", "Weasley"},
        };

        for (String[] data : studentData) {
            theStudents.add(new Student(data[0], data[1]));
        }
    }

    /**
     * 
     * @return
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
    
    // /**
    //  * 
    //  * @param studentId
    //  * @return
    //  */
    @GetMapping ("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (
            studentId >= theStudents.size() ||
            studentId < 0
        ) {
            
            throw new StudentNotFoundException(
                "Student id " + studentId + " not found!"
            );
        }

        return theStudents.get(studentId);
    }

    /**
     * @param entity
     * @return
     */
    @PostMapping 
    public ResponseEntity<StudentDto> createStudents(
        @RequestBody StudentDto theStudentDto
    ) {

        StudentDto saved = studentService.createStudent(theStudentDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}