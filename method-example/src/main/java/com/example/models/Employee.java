package com.example.models;

public class Employee {
  public int id;
  public int salary;
  public String name;
  public Character gender;

  public float calculateIncentive(){
    Float incentivePercentage  = (10f / 100);
    return this.salary * incentivePercentage;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", salary=" + salary +
        ", name='" + name + '\'' +
        '}';
  }
}
