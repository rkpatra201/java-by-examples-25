package com.example.arraylist.app;

import com.example.arraylist.models.Employee;
import com.example.arraylist.models.Student;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(12);

        // always need to typecast the original class for cloning
        List<Integer> cloneList = (ArrayList<Integer>) arrayList.clone();

        System.out.println("original:"+ arrayList);

        // This is a shallow copy: elements are not cloned, only the references are copied.
        System.out.println("clone list:"+ cloneList);


        // using object
        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student("john"));

        ArrayList<Student> list2 = (ArrayList<Student>) list1.clone();

       // If the list contains objects (e.g., Student), the cloned list shares the same objects.
        list2.get(0).name = "alice";
        System.out.println(list2.get(0).name );



    }
}
