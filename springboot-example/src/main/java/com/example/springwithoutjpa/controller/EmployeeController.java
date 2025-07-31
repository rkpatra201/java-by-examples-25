package com.example.controller;


import com.example.exception.ResourceNotFoundException;
import com.example.models.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // get/retrieve all employees rest api
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    // post/create employees rest api
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    // put/update the entire resource of employee column by id
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee updatedEmployee){
        Employee existingEmployee = employeeService.getById(id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmailId(updatedEmployee.getEmailId());
            return employeeService.save(existingEmployee);
        }
        return null;
    }

    // delete employee column by id
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
    }

    // patch/update only specified fields of employee
    @PatchMapping("/employee/{id}")
    public Employee partiallyUpdateEmployee(@PathVariable Long id , @RequestBody Employee updatedEmployee){
        Employee existingEmployee = employeeService.getById(id);
        if (existingEmployee != null) {
            if (updatedEmployee.getFirstName() != null) {
                existingEmployee.setFirstName(updatedEmployee.getFirstName());
            }
            if (updatedEmployee.getLastName() != null) {
                existingEmployee.setLastName(updatedEmployee.getLastName());
            }
            if (updatedEmployee.getEmailId() != null) {
                existingEmployee.setEmailId(updatedEmployee.getEmailId());
            }
            return employeeService.save(existingEmployee);
        }
        return null;
    }

}

