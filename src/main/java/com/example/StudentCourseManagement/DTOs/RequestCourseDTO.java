package com.example.StudentCourseManagement.DTOs;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class RequestCourseDTO {

    private String courseName;
    private String description;
    private Integer duration;


}
