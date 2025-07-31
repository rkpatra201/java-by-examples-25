package com.example.arraylist.app;

import com.example.arraylist.DeptComparator;
import com.example.arraylist.IdComparator;
import com.example.arraylist.NameComparator;
import com.example.arraylist.models.*;

import java.util.*;

// comparable and comparator
public class App5 {

    // sort using comparable
    public static void main(String[] args) {
       List<Employee> employeeList = new ArrayList<>();
       employeeList.add(new Employee(100,"john","electronic city"));
       employeeList.add(new Employee(101,"cina","bhubaneswar"));
       employeeList.add(new Employee(102,"ronit","ctc"));

        Collections.sort(employeeList);
//        System.out.println(employeeList);

       // sort using comparator
        ArrayList<Student1> arrayList = new ArrayList<>();
        arrayList.add(new Student1(100,"john","it"));
        arrayList.add(new Student1(101,"cina","electronics"));
        arrayList.add(new Student1(102,"tom","civil"));


        // sort by name
        Collections.sort(arrayList,new NameComparator());
//        System.out.println(arrayList);

        Collections.sort(arrayList,new IdComparator());
//        System.out.println(arrayList);

        // sort in a
        Collections.sort(arrayList,new DeptComparator());
        System.out.println(arrayList);




    }
}
