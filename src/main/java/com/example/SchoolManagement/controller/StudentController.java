package com.example.SchoolManagement.controller;

import com.example.SchoolManagement.exception.ResourceNotFoundException;
import com.example.SchoolManagement.model.Student;
import com.example.SchoolManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Create new student
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    // Get student by ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
        return ResponseEntity.ok(student);
    }

    // Update student
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        student.setFull_name(studentDetails.getFull_name());
        student.setInstitution(studentDetails.getInstitution());
        student.setProgram(studentDetails.getProgram());
        student.setEmail_id(studentDetails.getEmail_id());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete student
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Integer id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        studentRepository.delete(student);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
