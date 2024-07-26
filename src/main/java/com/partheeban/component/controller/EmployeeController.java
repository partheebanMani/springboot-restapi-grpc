package com.partheeban.component.controller;


import com.partheeban.component.model.Employee;
import com.partheeban.component.service.EmployeeService;
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

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployee() {
        log.info("Employee request controller");
        ResponseEntity<List<Employee>> listResponseEntity = new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
        log.info("Employee response controller {}",listResponseEntity.getStatusCode());
        log.debug("Employees response {}", listResponseEntity.getBody());
        return listResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id) {
        log.info("Employee request controller");
        return Optional.of(employeeService.getEmployee(id))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("Create employee request received with body {}", employee.toString());
        ResponseEntity<Employee> employeeResponseEntity = new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
        log.debug("Response for request {}", employeeResponseEntity);
        return employeeResponseEntity;
    }
}
