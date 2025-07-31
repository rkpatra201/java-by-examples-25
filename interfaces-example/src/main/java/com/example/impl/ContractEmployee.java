package com.example.impl;

public class ContractEmployee implements Employee {
  private String name;
  private String payrollCompany;

  public ContractEmployee(String name, String payrollCompany) {
    this.name = name;
    this.payrollCompany = payrollCompany;
  }

  @Override
  public String toString() {
    return "ContractEmployee{" +
        "name='" + name + '\'' +
        ", payrollCompany='" + payrollCompany + '\'' +
        '}';
  }
}
