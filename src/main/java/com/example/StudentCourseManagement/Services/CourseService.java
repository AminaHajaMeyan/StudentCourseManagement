package com.example.StudentCourseManagement.Services;
import com.example.StudentCourseManagement.DTOs.RequestCourseDTO;
import com.example.StudentCourseManagement.DTOs.ResponseCourseDTO;
import com.example.StudentCourseManagement.Entities.Course;
import com.example.StudentCourseManagement.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseCourseDTO saveCourse(RequestCourseDTO dto) {
        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        Course savedCourse = courseRepository.save(course);
        return new ResponseCourseDTO(savedCourse);
    }

    public List<ResponseCourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(ResponseCourseDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseCourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return new ResponseCourseDTO(course);
    }

    public ResponseCourseDTO updateCourse(RequestCourseDTO dto, Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setCourseName(dto.getCourseName());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        Course updatedCourse = courseRepository.save(course);
        return new ResponseCourseDTO(updatedCourse);
    }

    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
