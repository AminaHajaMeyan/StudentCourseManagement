package com.example.StudentCourseManagement.DTOs;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class RequestStudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String course;

}
