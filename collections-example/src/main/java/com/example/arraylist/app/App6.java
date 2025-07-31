package com.example.arraylist.app;

import com.example.arraylist.models.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// iterator and list iterator example
public class App6 {
    public static void main(String[] args) {
        List<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("john"));
        studentArrayList.add(new Student("happy"));
        studentArrayList.add(new Student("cina"));

        // will return the size of student
        System.out.println(studentArrayList.size());

        // iterate through the arraylist using iterator using while loop

        Iterator<Student> studentIterator = studentArrayList.iterator();
        // forward traversal
        while (studentIterator.hasNext()){
            Student name = studentIterator.next();
//            System.out.println(name);
        }

        // using enhanced for loop
        for (Student s : studentArrayList){
//            System.out.println(s);
        }

       // forward iterate through the arraylist using list iterator using while loop
        ListIterator<Student> listIterator = studentArrayList.listIterator();
        while (listIterator.hasNext()){
            Student name = listIterator.next();
//            System.out.println(name);
        }

        // backword iterate through the arrayList using list iterator
        while (listIterator.hasPrevious()){
            Student name = listIterator.previous();
            System.out.println(name);
        }
    }
}
