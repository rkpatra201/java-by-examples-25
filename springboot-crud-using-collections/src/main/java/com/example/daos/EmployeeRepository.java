package com.example.daos;

import com.example.models.Employee;
import org.apache.catalina.User;

import java.util.List;

public interface EmployeeRepository {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee updateEmployee(Long id,Employee employee);
    public boolean deleteEmployeeById(Long id);
}
