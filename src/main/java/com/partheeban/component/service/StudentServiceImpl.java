package com.partheeban.component.service;

import com.partheeban.component.model.Student;
import com.partheeban.component.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Integer id) {
        return studentRepository.findById(id.longValue());
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
