package com.example.arraylist;


import com.example.arraylist.models.Student1;

import java.util.Comparator;


// sort multiple object using comparator interface
public class NameComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 o1, Student1 o2){
        return o1.name.compareTo(o2.name);
    }

}
