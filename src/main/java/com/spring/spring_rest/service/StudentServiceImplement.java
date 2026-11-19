package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

/**
 * Service implementation class for {@link StudentService}.
 * Handles business logic and data mapping.
 */
@Service 
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepo;

    /**
     * Class constructor
     * 
     * @param studentRepo
     */
    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * Creates and persists new student record.
     * 
     * @param theStudentDto data transfer object containing the student deets.
     * @return the saved {@link StudentDto}
     */
    @Override
    public StudentDto createStudent(StudentDto theStudentDto) {
        Student theStudent = StudentMapper.mapToStudent(theStudentDto);
        Student saved = studentRepo.save(theStudent);

        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Retrieves specific student record by ID.
     * 
     * @param theId the id of student to retrieve.
     * @return the {@link StudentDto} matching the ID.
     */
    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo
            .findById(theId)
            .orElseThrow(
                () -> new StudentNotFoundException(
                    "Student id " + theId + " not found!"
                )
            );

        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * Retrieves all existing student records.
     * 
     * @return a List of all {@link StudentDto} objects.
     */
    @Override 
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();

        return students
            .stream()
            .map((student)-> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**
     * Replacing and existing student record with updated details.
     * 
     * @param theId the ID of student to be updated.
     * @param theStudentDto data transfer object containing the student deets.
     * @return the updated {@link StudentDto}
     */
    @Override 
    public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
        Student student = StudentMapper.mapToStudent(getStudentById(theId));

        student.setFirstName(theStudentDto.getFirstName());
        student.setLastName(theStudentDto.getLastName());
        student.setEmail(theStudentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Partially updates existing student record.
     * Can accept null fields from param DTO.
     * 
     * @param theId the ID of student to be updated.
     * @param theStudentDto data transfer object containing the student deets.
     * @return the updated {@link StudentDto}
     */
    @Override 
    public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
        Student student = StudentMapper.mapToStudent(getStudentById(theId));

        if (theStudentDto.getFirstName() != null) {
            student.setFirstName(theStudentDto.getFirstName());
        }

        if (theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }

        if (theStudentDto.getEmail() != null) {
            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Deletes a specific student record by ID.
     * 
     * @param theId the ID of student to be deleted.
     */
    @Override 
    public void deleteStudentById(Long theId) {
        getStudentById(theId);
        studentRepo.deleteById(theId);
    }
}
