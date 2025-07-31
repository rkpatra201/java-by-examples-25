package com.example.daos;

import com.example.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("originalEmployeeRepository")
public class OriginalEmployeeRepository implements EmployeeRepository{
    private final Map<Long,Employee> store = new HashMap<>();
    private long currentId = 1;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(currentId++);
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return store.get(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = store.get(id);
        if (existingEmployee != null){
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
        }
        return existingEmployee;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        return store.remove(id) != null;
    }
}
