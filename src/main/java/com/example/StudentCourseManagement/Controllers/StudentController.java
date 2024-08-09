package com.example.StudentCourseManagement.Controllers;

import com.example.StudentCourseManagement.DTOs.RequestStudentDTO;
import com.example.StudentCourseManagement.DTOs.ResponseStudentDTO;
import com.example.StudentCourseManagement.Services.StudentService;
import com.example.StudentCourseManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StandardResponse> createStudent(@RequestBody RequestStudentDTO dto) {
        ResponseStudentDTO responseDTO = studentService.saveStudent(dto);
        return new ResponseEntity<>(
                new StandardResponse("Student Created", HttpStatus.CREATED.value(), responseDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents() {
        List<ResponseStudentDTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(
                new StandardResponse("Students Fetched", HttpStatus.OK.value(), students),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getStudentById(@PathVariable Long id) {
        ResponseStudentDTO student = studentService.getStudentById(id);
        return new ResponseEntity<>(
                new StandardResponse("Student Fetched", HttpStatus.OK.value(), student),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> updateStudent(
            @RequestBody RequestStudentDTO dto,
            @PathVariable Long id
    ) {
        ResponseStudentDTO updatedStudent = studentService.updateStudent(dto, id);
        return new ResponseEntity<>(
                new StandardResponse("Student Updated", HttpStatus.OK.value(), updatedStudent),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return new ResponseEntity<>(
                    new StandardResponse("Student Deleted", HttpStatus.NO_CONTENT.value(), null),
                    HttpStatus.NO_CONTENT
            );
        } else {
            return new ResponseEntity<>(
                    new StandardResponse("Student Not Found", HttpStatus.NOT_FOUND.value(), null),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}


