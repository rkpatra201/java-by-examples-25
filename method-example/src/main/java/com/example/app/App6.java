package com.example.app;

import com.example.models.Employee;
import com.example.service.EmployeeService;

import java.util.Arrays;

public class App6 {

  // this: non-static class level variable or method
  public static void main(String[] args) {
    Employee e1 = createEmployee(10, 10_000, "Alex", 'M');
    Employee e2 = createEmployee(11, 30_000, "Kelly", 'F');
    Employee e3 = createEmployee(12, 40_000, "Jesica", 'F');
    Employee e4 = createEmployee(13, 50_000, "John", 'M');

    EmployeeService service = new EmployeeService();
    Employee[] result = service.findAll(new Employee[]{e1,e2,e3,e4}, 'F');
    System.out.println(Arrays.toString(result));
  }

  private static Employee createEmployee(int id, int salary, String name, Character gender){
    Employee e = new Employee();
    e.id = id;
    e.salary = salary;
    e.name = name;
    e.gender = gender;
    return e;
  }
}
