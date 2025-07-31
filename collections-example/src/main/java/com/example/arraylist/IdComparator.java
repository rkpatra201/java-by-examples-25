package com.example.arraylist;

import com.example.arraylist.models.Student1;

import java.util.Comparator;

public class IdComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o2.id.compareTo(o1.id);
    }
}
