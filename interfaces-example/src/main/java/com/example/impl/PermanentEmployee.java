package com.example.impl;

public class PermanentEmployee implements Employee {
  private String name;
  private String employeeId;

  public PermanentEmployee(String name, String employeeId) {
    this.name = name;
    this.employeeId = employeeId;
  }

  @Override
  public String toString() {
    return "PermanentEmployee{" +
        "name='" + name + '\'' +
        ", employeeId='" + employeeId + '\'' +
        '}';
  }
}
