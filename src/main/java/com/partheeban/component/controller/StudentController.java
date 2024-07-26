package com.partheeban.component.controller;

import com.partheeban.component.model.Student;
import com.partheeban.component.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    private StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents(){
        log.info("GET student request is received");
        ResponseEntity<List<Student>> listResponseEntity = new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        log.debug("Response for GET students request, status code {}, response body {}", listResponseEntity.getStatusCode(), listResponseEntity.getBody());
        return listResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable("id") Integer id)  {
        log.info("GET employee request received for ID {}", id);
        return Optional.of(studentService.getStudent(id))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @PostMapping("/")
    public ResponseEntity<Student> putStudent(@RequestBody Student student){
        log.info("POST request received for student");
        log.debug("POST request received for student with request body {}", student);
        ResponseEntity<Student> studentResponseEntity = new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
        log.info("POST request response code {}",studentResponseEntity.getStatusCode());
        log.debug("POST student response {}", studentResponseEntity.getBody());
        return studentResponseEntity;
    }

}
