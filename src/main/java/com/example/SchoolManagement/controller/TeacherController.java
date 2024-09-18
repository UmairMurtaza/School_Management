package com.example.SchoolManagement.controller;

import com.example.SchoolManagement.exception.ResourceNotFoundException;
import com.example.SchoolManagement.model.Teacher;
import com.example.SchoolManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    // Get all teachers
    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Create a new teacher
    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Get teacher by ID
    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        return ResponseEntity.ok(teacher);
    }

    // Update a teacher
    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));

        teacher.setFull_name(teacherDetails.getFull_name());
        teacher.setQualification(teacherDetails.getQualification());
        teacher.setSalary(teacherDetails.getSalary());
        teacher.setAddress(teacherDetails.getAddress());
        teacher.setEmail(teacherDetails.getEmail());

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    // Delete a teacher
    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTeacher(@PathVariable Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));

        teacherRepository.delete(teacher);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
