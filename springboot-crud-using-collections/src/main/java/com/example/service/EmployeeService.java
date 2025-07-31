package com.example.service;

import com.example.daos.EmployeeRepository;
import com.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
//    @Qualifier("dummyEmployeeRepository")
    @Qualifier("originalEmployeeRepository")
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.updateEmployee(id, employee);
    }

    public boolean deleteEmployeeById(Long id) {
        return employeeRepository.deleteEmployeeById(id);
    }
}
