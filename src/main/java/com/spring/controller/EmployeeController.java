package com.spring.controller;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.update(employee, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);


    }

}
