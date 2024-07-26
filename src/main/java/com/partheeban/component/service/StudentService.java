package com.partheeban.component.service;

import com.partheeban.component.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public List<Student> getStudents();

    public Optional<Student> getStudent(Integer id);

    public Student saveStudent(Student student);
}
