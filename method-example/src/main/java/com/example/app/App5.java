package com.example.app;

import com.example.models.Employee;
import com.example.service.EmployeeService;

import java.util.Arrays;

// object type as method params
// object type as return value
// array as param
// array as return type
public class App5 {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.id = 10;
    e1.name = "John";
    e1.salary = 2_000;

    Employee e2 = new Employee();
    e2.id = 11;
    e2.name = "Alex";
    e2.salary = 100_000;

    Employee e3 = new Employee();
    e3.id = 12;
    e3.name = "Alex";
    e3.salary = 50_000;

    // 4kb
    // EmployeeService class is stateless in nature, so dont create many objects.
    // create just one object and pass it as parameter of the method
    EmployeeService service = new EmployeeService(); // how many objects required
    float result1 = service.calculateIncentive(e1);
    float result2 = service.calculateIncentive(e2);
    System.out.println(result1);
    System.out.println(result2);

    Employee[] employees = {e1, e3, e2};
    Employee employeeResult = service.findFirst(employees);
    System.out.println(employeeResult);

    Employee[] matchAll = service.findAll(employees);
    System.out.println(Arrays.toString(matchAll));

  }
}
