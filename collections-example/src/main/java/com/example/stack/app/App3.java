package com.example.stack.app;

import java.util.Stack;

// //Given parathensis in a string. Check if it is balanced then return true otherwise false.
public class App3 {
    public static void main(String[] args) {

        String pattern = "(({{}}))";
        boolean result = isValid(pattern);
        System.out.println("is it a valid pattern:"+result);
    }
    public static boolean isValid(String s){

        // store the string into a char array to check each index repeatedly
        char[] ch = s.toCharArray();

        // stack to compare the string
        Stack<Character> stringStack = new Stack<>();

        for (int i =0 ; i<ch.length ; i++){

            // check for opening character if found then push to stack
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '[' ){
                stringStack.push(ch[i]);
            }
            // check for closing parentheses if found check if opening bracket is present or not
            // if not present return false if present fetch top element and compare
            else if(ch[i] == ')' || ch[i] == '}' || ch[i] == ']' ){
                if(stringStack.isEmpty()){
                    return false;
                }

                // fetch the top element from stack and compare if not equal then return false
                char top = stringStack.pop();
                if(ch[i] == '(' && top != '}'||
                   ch[i] == '{' && top != '}' ||
                   ch[i] ==  '[' && top != ']'){
                    return false;
                }
            }
        }

        return stringStack.isEmpty();
    }
}
