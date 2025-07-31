package com.example.arraylist.app;

import com.example.arraylist.models.Student;

import java.util.ArrayList;

public class App3 {
    public static void main(String[] args) {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("john");
        originalList.add("alice");
        originalList.add("jack");

        //Copy using constructor
        ArrayList<String> copyList = new ArrayList<>(originalList);

        // This is a shallow copy
        System.out.println(originalList);
        System.out.println(copyList);

        // using object

        ArrayList<Student> originalList1 = new ArrayList<>();
        originalList1.add(new Student("ram"));
        originalList1.add(new Student("syam"));
        originalList1.add(new Student("som"));

        ArrayList<Student> copyList1 = new ArrayList<>(originalList1);

        System.out.println(originalList1);
        System.out.println(copyList1);

        // using deep copy



    }
}
