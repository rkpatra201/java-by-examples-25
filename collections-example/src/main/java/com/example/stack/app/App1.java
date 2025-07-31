package com.example.stack.app;

import java.util.Stack;


// stack implementation , it is a child class of vector
public class App1 {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(10);
        integerStack.push(11);
        integerStack.push(12);

//        System.out.println(integerStack);

        // pop operation will show which one will last in that one will first out (lifo)
        // isEmpty() this method will check the stack have any element or not
        // pop() will extract element form the stack
        while (!integerStack.isEmpty()){
            System.out.println(integerStack.pop());
        }

        // check the stack after pop operation it will show empty stack
        System.out.println(integerStack);

    }
}
