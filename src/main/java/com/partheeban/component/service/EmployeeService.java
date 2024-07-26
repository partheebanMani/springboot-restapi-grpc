package com.partheeban.component.service;

import com.partheeban.component.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getEmployee();

    public Optional<Employee> getEmployee(Long id);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Long id);

}
