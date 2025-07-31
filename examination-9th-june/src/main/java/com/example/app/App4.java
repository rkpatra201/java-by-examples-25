package com.example.app;

import java.util.Scanner;
import java.util.Stack;

public class App4 {
    public static void main(String[] args) {
        String input1 = "((())())";
        String input2 = ")()()(";
        String input3 = "(()())";
        String input4 = "(())())";
        System.out.println("Input1: "+ input1);
        System.out.println(checkBalancedParameter(input1));  //true
        System.out.println("Input2: "+ input2);
        System.out.println(checkBalancedParameter(input2));  //false
        System.out.println("Input1: "+ input3);
        System.out.println(checkBalancedParameter(input3));  //true
        System.out.println("Input1: "+ input4);
        System.out.println(checkBalancedParameter(input4));  //false
    }

    private static boolean checkBalancedParameter(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
