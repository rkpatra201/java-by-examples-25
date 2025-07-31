package com.example.queue.app;

import com.example.queue.models.Employee;

import java.util.*;

public class App2 {
    public static void main(String[] args) {
        Queue<Employee> employeeQueue1 = new LinkedList<>();
        employeeQueue1.offer(new Employee(500 ,"micheal"));
        employeeQueue1.offer(new Employee(501 ,"scotie"));
        employeeQueue1.offer(new Employee(502 ,"denis"));
        employeeQueue1.offer(new Employee(503 ,"steph"));

        // iterate queue using iterator
        Iterator<Employee> employeeIterator = employeeQueue1.iterator();
        while (employeeIterator.hasNext()){
            System.out.print(employeeIterator.next() + " ");
        }

        System.out.println("\n");
        // using listIterator

        ListIterator<Employee> employeeListIterator = ((LinkedList<Employee>) employeeQueue1).listIterator();
        while (employeeListIterator.hasNext()){
            System.out.print(employeeListIterator.next() + " ");
        }
    }
}
