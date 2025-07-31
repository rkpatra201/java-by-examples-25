package com.example.app;

import java.util.Stack;

public class App1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);

        System.out.println("Stack: "+ stack);
        System.out.println("Peek element: "+ stack.peek());
        System.out.println("Pop element: "+ stack.pop());
        System.out.println("Stack after pop: "+ stack);
    }
}
