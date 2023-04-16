package com.spring.service;

import com.spring.exception.EmployeeNotFoundException;
import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) throws EmployeeNotFoundException {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            return Optional.of(emp.get());
        } else {
            throw new EmployeeNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee", "Id", id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setRole(employee.getRole());
        return existingEmployee;
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);

    }
}
