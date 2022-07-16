package com.springboottut.springboottut.controller;

import com.springboottut.springboottut.exception.ResourceNotFoundException;
import com.springboottut.springboottut.model.Employee;
import com.springboottut.springboottut.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee>getAllEmployees(){
        return employeeRepository.findAll();
    }
    // build create employee api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    //get employee by id
    @RequestMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exits with" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
            Employee updateEmployee = employeeRepository
                    .findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exits with" + id));
            updateEmployee.setFirstName(employee.getFirstName());
            updateEmployee.setLastName(employee.getLastName());
            updateEmployee.setEmail(employee.getEmail());
            employeeRepository.save(updateEmployee);
            return ResponseEntity.ok(updateEmployee);
    }

    //Build delete employee
    @DeleteMapping ("{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exits with" + id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}