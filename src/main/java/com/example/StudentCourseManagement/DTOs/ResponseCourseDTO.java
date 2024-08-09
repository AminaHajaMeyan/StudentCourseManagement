package com.example.StudentCourseManagement.DTOs;

import com.example.StudentCourseManagement.Entities.Course;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ResponseCourseDTO {

    private Long id;
    private String courseName;
    private String description;
    private Integer duration;

    public ResponseCourseDTO(Course course) {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
        this.duration = course.getDuration();
    }
}
