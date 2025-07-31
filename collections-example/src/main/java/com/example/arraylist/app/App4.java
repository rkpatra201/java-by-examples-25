package com.example.arraylist.app;

import com.example.arraylist.models.Student;

import java.util.ArrayList;


// deep copy example
public class App4 {
    public static void main(String[] args) {
        ArrayList<Student> originalList = new ArrayList<>();
        originalList.add(new Student("hari"));
        originalList.add(new Student("shyam"));
        originalList.add(new Student("radha"));

        // deep clone of the list

        ArrayList<Student> deepCloneList = new ArrayList<>();
        for (Student s : originalList){
            deepCloneList.add(s.clone()); // it will clone each object
        }

        // modify deep clone list
        deepCloneList.get(0).name = "hrushikesh";

        System.out.println("original list :"+ originalList);
        System.out.println("deepclone list :"+ deepCloneList);


        // using copy constructor

         ArrayList<Student> copiedList = new ArrayList<>();
         for (Student s: originalList){
             copiedList.add(new Student(s)); // calls copy constructor
         }

         copiedList.get(0).name = " sahitya";
         System.out.println("\n");
         System.out.println("original list :"+ originalList);
         System.out.println("deepclone list :"+ deepCloneList);
    }
}
