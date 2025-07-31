package com.example.service;

import com.example.models.Employee;

public class EmployeeService {

  public float calculateIncentive(Employee e) {
    Float incentivePercentage = (10f / 100);
    return e.salary * incentivePercentage;
  }

  // first employee who gets salary more than 20k
  public Employee findFirst(Employee[] employees) {
    Employee temp = null;
    for (Employee e : employees) {
      if (e.salary > 20_000) {
        temp = e;
        break;
      }
    }

    return temp;
  }

  // find all employee who gets salary more than 20k
  public Employee[] findAll(Employee[] employees) {
    Employee[] temp = new Employee[employees.length];
    int tempIndex = 0;
    for (int i = 0; i < employees.length; i++) {
      Employee e = employees[i];
      if (e == null) {
        continue;
      }
      if (e.salary > 20_000) {
        temp[tempIndex] = e;
        tempIndex++;
      }
    }
    return temp;
  }

  // find all female/male employee who are getting more than 20k salary
  public Employee[] findAll(Employee[] employees, Character gender) {
    Employee[] genderFilteredEmployees = this.findEmployeeByGender(employees, gender);
    Employee[] result = this.findAll(genderFilteredEmployees);
    return result;
  }

  private Employee[] findEmployeeByGender(Employee[] employees, Character gender) {
    Employee[] result = new Employee[employees.length];
    int index = 0;
    for (Employee e : employees) {
      if (e.gender == gender) {
        result[index] = e;
        index++;
      }
    }

    return result;
  }
}
