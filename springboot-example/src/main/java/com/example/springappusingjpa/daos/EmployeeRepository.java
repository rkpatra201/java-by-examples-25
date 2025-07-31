package com.example.springappusingjpa.daos;

import com.example.springappusingjpa.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{

}
