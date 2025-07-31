package com.example.app;

import com.example.impl.ContractEmployee;
import com.example.impl.Employee;
import com.example.impl.PermanentEmployee;


// custom marker interface
public class App2 {
  public static void main(String[] args) {
    ContractEmployee e1 = new ContractEmployee("John", "TCS");
    PermanentEmployee e2 = new PermanentEmployee("Alex", "E1234");
    Object[] employees = {e1, e2};
    Employee[] arr1 = {e1, e2};
    Employee e33 = e1;
  }
}
