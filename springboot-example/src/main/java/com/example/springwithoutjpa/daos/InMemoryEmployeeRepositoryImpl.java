package com.example.daos;

import com.example.models.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


// It acts like a mini in-memory database layer for your application.
@Repository
@Qualifier("inMemoryEmployeeRepository")
public class InMemoryEmployeeRepositoryImpl implements EmployeeRepository{
    private final Map<Long, Employee> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(idGenerator.incrementAndGet());
        }
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Employee findById(Long id) {
        return store.get(id);
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
