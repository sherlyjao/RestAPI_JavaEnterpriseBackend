package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * StudentRestController
 */
@RestController 
@RequestMapping ("/api")
public class StudentRestController {

    private List<Student> theStudents;

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
    
    /**
     * 
     * @param studentId
     * @return
     */
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
}