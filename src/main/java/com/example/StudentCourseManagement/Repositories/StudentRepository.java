package com.example.StudentCourseManagement.Repositories;

import com.example.StudentCourseManagement.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
