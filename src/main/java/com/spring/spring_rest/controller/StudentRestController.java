package com.spring.spring_rest.controller;

// import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.spring_rest.dto.StudentDto;
// import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;
// import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * REST controller handling HTTP requests for student CRUD operations,
 * under the {@code /api/students} endpoint.
 */
@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {
    //==========
    // Fields
    //==========
    // private List<Student> theStudents;
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
    // @PostConstruct 
    // public void initialize() {
    //     theStudents = new ArrayList<>();

    //     String[][] studentData = {
    //         {"Harry James", "Potter"},
    //         {"Hermione", "Granger"},
    //         {"Ronald", "Weasley"},
    //     };

    //     for (String[] data : studentData) {
    //         theStudents.add(new Student(data[0], data[1]));
    //     }
    // }

    /**
     * Retrieves the in-memory list of all {@code Student} objects.
     * 
     * @return a List containing all sample Student records.
     */
    // @GetMapping("/students")
    // public List<Student> getStudents() {
    //     return theStudents;
    // }
    
    /**
     * Retrieves a single Student from the in-memory list by its ID.
     * 
     * @param studentId the ID of student to be retrieved.
     * @return a Student matching the ID.
     */
    // @GetMapping ("/students/{studentId}")
    // public Student getStudent(@PathVariable int studentId) {

    //     if (
    //         studentId >= theStudents.size() ||
    //         studentId < 0
    //     ) {
            
    //         throw new StudentNotFoundException(
    //             "Student id " + studentId + " not found!"
    //         );
    //     }

    //     return theStudents.get(studentId);
    // }

    /**
     * Creates a new student record from the validated request body.
     * 
     * @param entity the valid {@link StudentDto} containing the student deets.
     * @return a {@link ResponseEntity} containing the saved object and status.
     */
    @PostMapping 
    public ResponseEntity<StudentDto> createStudents(
        @Valid @RequestBody StudentDto theStudentDto
    ) {

        StudentDto saved = studentService.createStudent(theStudentDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Retrieves a specific student record by its unique identifier.
     * 
     * @param id the unique ID of the student to retrieve.
     * @return a {@link ResponseEntity} containing the saved object and status.
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(
        @PathVariable Long id
    ) {

        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    
    /**
     * Retrieves all existing student records.
     * 
     * @return a {@link ResponseEntity} containing the saved object and status.
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    /**
     * Replaces an existing student record with the provided validated data.
     * 
     * @param id the unique ID of the student to update.
     * @param theStudentDto valid object containing the updated student deets.
     * @return a {@link ResponseEntity} containing updated object and status.
     */
    @PutMapping ("{id}")
    public ResponseEntity<StudentDto> updateStudent(
        @PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {

        return ResponseEntity.ok(
            studentService.updateStudent(id, theStudentDto)
        );
    }

    /**
     * Partially updates an existing student record.
     * Can accept null fields from param DTO.
     * 
     * @param id the unique ID of the student to update.
     * @param theStudentDto valid object containing the updated student deets.
     * @return a {@link ResponseEntity} containing updated object and status.
     */
    @PatchMapping ("{id}")
    public ResponseEntity<StudentDto> patchStudent(
        @PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {

        return ResponseEntity.ok(
            studentService.patchStudent(id, theStudentDto)
        );
    }

    /**
     * Deletes a student record by its unique identifier.
     * 
     * @param id the unique ID of the student to delete.
     * @return a {@link ResponseEntity} with confirmation message and status.
     */
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteStudentById(
        @PathVariable Long id
    ) {

        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}