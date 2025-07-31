package com.example.daos;


import com.example.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee , Long> {
//
//}
import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(Long id);
    void delete(Long id);
}
