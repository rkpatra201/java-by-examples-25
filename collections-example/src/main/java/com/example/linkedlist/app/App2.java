package com.example.linkedlist.app;

import com.example.linkedlist.models.Employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// iterator and listiterator example
public class App2 {
    public static void main(String[] args) {
        LinkedList<Employee> employeeLinkedList = new LinkedList<>();
        employeeLinkedList.add(new Employee(400));
        employeeLinkedList.add(new Employee(600));
        employeeLinkedList.add(new Employee(500));

        Iterator<Employee>employeeIterator = employeeLinkedList.iterator();

        // traverse through linkedlist using while loop
        while (employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
//            System.out.println(employee);
        }


        // example using listIterator

        ListIterator<Employee> listIterator = employeeLinkedList.listIterator();
        while (listIterator.hasNext()){
            Employee employee1 = listIterator.next();
//            System.out.println(employee1);
        }

        // backward traversal

        while (listIterator.hasPrevious()){
            Employee employee = listIterator.previous();
            System.out.println(employee);
        }
    }
}
