package com.example.StudentCourseManagement.Repositories;

import com.example.StudentCourseManagement.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
