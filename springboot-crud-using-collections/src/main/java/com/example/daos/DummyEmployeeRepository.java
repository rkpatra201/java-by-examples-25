package com.example.daos;

import com.example.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("dummyEmployeeRepository")
public class DummyEmployeeRepository implements EmployeeRepository{
    @Override
    public Employee createEmployee(Employee employee) {
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return Collections.emptyList();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        return false;
    }
}
