package com.example.models;

import java.util.Objects;

public class Employee // extends Object
 {
  public static String deptName;
  public int id;
  public int salary;
  public String name;

  public String getDesignation(){
    if(this.salary >= 100 && this.salary < 200){
      return "Grade A";
    } else if (this.salary >= 200) {
      return "Grade B";
    }
    return "NA"; // not avaialable
  }

  public boolean increment(){
    int newSalary = this.salary + 100;
    this.salary = newSalary;
    return true;
  }

   @Override
   public boolean equals(Object objectToBeCompare) {
    if(objectToBeCompare == null){// cant compare with null object
      return false;
    }

    // Employee != Student
    if(this.getClass() != objectToBeCompare.getClass()){ // cant compare with dfnt types of object
      return false;
    }
    // now compare with the same type of object
    Employee param = (Employee) objectToBeCompare;
    return Objects.equals(this.id, param.id);
//       && Objects.equals(this.name, param.name);
   }


   @Override
   public int hashCode() {
     return Objects.hash(this.id);
   }

   @Override
   public String toString() {
     return "Employee{" +
         "id=" + id +
         ", deptName=" + deptName +
         ", salary=" + salary +
         ", name='" + name + '\'' +
         '}';
   }
 }
