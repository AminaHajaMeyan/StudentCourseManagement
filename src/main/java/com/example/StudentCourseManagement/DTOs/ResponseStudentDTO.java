package com.example.StudentCourseManagement.DTOs;

import com.example.StudentCourseManagement.Entities.Student;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ResponseStudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String course;

    public ResponseStudentDTO(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.course = student.getCourse();
    }
}
