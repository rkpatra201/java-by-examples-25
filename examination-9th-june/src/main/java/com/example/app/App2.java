package com.example.app;

import com.example.models.Employee;

import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Alice",23));
        employees.add(new Employee("Max",20));
        employees.add(new Employee("Alex",18));
        employees.add(new Employee("Robin",17));
        employees.add(new Employee("Bob",19));

        System.out.println("Greater than 18 year old employees: ");
        for (Employee i : employees ){
//            employees.remove(i);   // Throws ConcurrentModificationException exception
            if (i.age > 18){
                System.out.println(i.name);
            }
        }
    }
}
