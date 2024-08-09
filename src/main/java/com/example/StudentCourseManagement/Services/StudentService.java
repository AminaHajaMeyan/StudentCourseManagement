package com.example.StudentCourseManagement.Services;

import com.example.StudentCourseManagement.DTOs.RequestStudentDTO;
import com.example.StudentCourseManagement.DTOs.ResponseStudentDTO;
import com.example.StudentCourseManagement.Entities.Student;
import com.example.StudentCourseManagement.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseStudentDTO saveStudent(RequestStudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        Student savedStudent = studentRepository.save(student);
        return new ResponseStudentDTO(savedStudent);
    }

    public List<ResponseStudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(ResponseStudentDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseStudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return new ResponseStudentDTO(student);
    }

    public ResponseStudentDTO updateStudent(RequestStudentDTO dto, Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        Student updatedStudent = studentRepository.save(student);
        return new ResponseStudentDTO(updatedStudent);
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
