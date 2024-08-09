package com.example.StudentCourseManagement.Controllers;

import com.example.StudentCourseManagement.DTOs.RequestCourseDTO;
import com.example.StudentCourseManagement.DTOs.ResponseCourseDTO;
import com.example.StudentCourseManagement.Services.CourseService;
import com.example.StudentCourseManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<StandardResponse> createCourse(@RequestBody RequestCourseDTO dto) {
        ResponseCourseDTO responseDTO = courseService.saveCourse(dto);
        return new ResponseEntity<>(
                new StandardResponse("Course Created", HttpStatus.CREATED.value(), responseDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCourses() {
        List<ResponseCourseDTO> courses = courseService.getAllCourses();
        return new ResponseEntity<>(
                new StandardResponse("Courses Fetched", HttpStatus.OK.value(), courses),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getCourseById(@PathVariable Long id) {
        ResponseCourseDTO course = courseService.getCourseById(id);
        return new ResponseEntity<>(
                new StandardResponse("Course Fetched", HttpStatus.OK.value(), course),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> updateCourse(
            @RequestBody RequestCourseDTO dto,
            @PathVariable Long id
    ) {
        ResponseCourseDTO updatedCourse = courseService.updateCourse(dto, id);
        return new ResponseEntity<>(
                new StandardResponse("Course Updated", HttpStatus.OK.value(), updatedCourse),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCourse(@PathVariable Long id) {
        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return new ResponseEntity<>(
                    new StandardResponse("Course Deleted", HttpStatus.NO_CONTENT.value(), null),
                    HttpStatus.NO_CONTENT
            );
        } else {
            return new ResponseEntity<>(
                    new StandardResponse("Course Not Found", HttpStatus.NOT_FOUND.value(), null),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
