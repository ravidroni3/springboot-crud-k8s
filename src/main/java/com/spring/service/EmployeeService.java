package com.spring.service;

import com.spring.exception.EmployeeNotFoundException;
import com.spring.model.Employee;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    Optional<Employee> findById(Integer id) throws EmployeeNotFoundException;

    Employee update(Employee employee, Integer id);

    void delete(Integer id);
}
