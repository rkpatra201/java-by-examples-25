package com.example.set.app;

import com.example.set.models.Employee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//
public class App4 {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();

        // add employee object to the hashset
        employeeSet.add(new Employee(100, "john"));
        employeeSet.add(new Employee(101, "jockey"));
        employeeSet.add(new Employee(102, "jack"));

        System.out.println(employeeSet);

        // remove object from the set
        employeeSet.remove(new Employee(100,"john"));
        System.out.println(employeeSet);

        // validate object is present or not
        System.out.println(employeeSet.contains(new Employee(102,"jack")));

        // iterate over hashset using iterator
        Iterator<Employee> employeeIterator = employeeSet.iterator();
        while (employeeIterator.hasNext()){
            System.out.print(employeeIterator.next() + " ");
        }
    }


}
