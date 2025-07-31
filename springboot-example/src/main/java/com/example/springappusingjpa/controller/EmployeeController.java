package com.example.springappusingjpa.controller;

import com.example.springappusingjpa.daos.EmployeeRepository;
import com.example.springappusingjpa.models.Employees;
import com.example.springwithoutjpa.exception.ResourceNotFoundException;
import com.example.springwithoutjpa.models.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get operation
    @GetMapping("/employee")
    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // post/create employees
    @PostMapping("/employee")
    public Employees createEmployee (@RequestBody Employees employees){
        return employeeRepository.save(employees);
    }
    // put / update by id employees
    @PutMapping("/employee/{id}")
    public Employees updateEmployee (@PathVariable Long id , @RequestBody Employees updatedEmplyees){
            Optional<Employees> existingEmployee = employeeRepository.findById(id);
            if (!existingEmployee.isPresent()){
              throw new ResourceNotFoundException("employee not found with id");
            }
            Employees employees = existingEmployee.get();
            employees.setEmailId(updatedEmplyees.getEmailId());
            employees.setFirstName(updatedEmplyees.getFirstName());
            employees.setLastName(updatedEmplyees.getLastName());
            return employeeRepository.save(employees);
    }

    @PatchMapping("/employee/{id}")
    public Employees updateGivenColumn (@PathVariable Long id , @RequestBody Employees updateEmployee){
        Optional<Employees> existingEmployeeRow = employeeRepository.findById(id);
        if (!existingEmployeeRow.isPresent()){
            throw new ResourceNotFoundException("employee id not found");
        }
        Employees employees = existingEmployeeRow.get();
       if(updateEmployee.getEmailId() != null ){
           employees.setEmailId(updateEmployee.getEmailId());
       } if(updateEmployee.getFirstName() != null ){
           employees.setFirstName(updateEmployee.getFirstName());
       } if(updateEmployee.getEmailId() != null ){
           employees.setLastName(updateEmployee.getLastName());
       }
       return employeeRepository.save(employees);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        Optional<Employees> deleteEmployee = employeeRepository.findById(id);
            if (!deleteEmployee.isPresent()){
                throw new ResourceNotFoundException("employee is not found ");
            }
            employeeRepository.deleteById(id);
            return "Employee deleted with id:  "  + id ;
    }
}
