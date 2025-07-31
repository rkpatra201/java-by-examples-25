package com.example.stack.app;

import com.example.stack.models.Employee;

import java.util.Stack;

public class App2 {
    public static void main(String[] args) {
        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.push(new Employee(101 , "john"));
        employeeStack.push(new Employee(102 , "ronny"));
        employeeStack.push(new Employee(103 , "saksi"));

        // access the top element of the stack
        System.out.println(employeeStack.peek());
        // o/p ; Employee{id=103, name='saksi'}


        // will return number of element in the stack
        System.out.println(employeeStack.size());


        // clear() method will delete all element from the stack
        employeeStack.clear();
        System.out.println(employeeStack);

    }
}
