package com.example.app;

import com.example.models.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseSortByComparator {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee(1,"Alex", "Hydrabad");
        employees[1] = new Employee(2,"Bob","Banglore");
        employees[2] = new Employee(3,"Max", "Delhi");
        employees[3] = new Employee(4,"Harry", "Bhubaneswar");
        employees[3] = new Employee(4,"Alex", "Bhubaneswar");

        //By Comparator (reverse)
        Arrays.sort(employees, Comparator.comparing(emp -> emp.name, Comparator.reverseOrder()));
        System.out.println("Reverse sort by name using comparator: "+Arrays.toString(employees));
        //[3-Max-Delhi, 2-Bob-Banglore, 1-Alex-Hydrabad, 4-Alex-Bhubaneswar]

        //By Comparator
        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getCity));
        System.out.println("Reverse sort by name then city using comparator: "+Arrays.toString(employees));
        //[4-Alex-Bhubaneswar, 1-Alex-Hydrabad, 2-Bob-Banglore, 3-Max-Delhi]

        //By Comparable (reverse)
        Arrays.sort(employees);
        System.out.println("Reverse sort by ID using comparable: "+Arrays.toString(employees));
        //[4-Alex-Bhubaneswar, 3-Max-Delhi, 2-Bob-Banglore, 1-Alex-Hydrabad]


    }
}
