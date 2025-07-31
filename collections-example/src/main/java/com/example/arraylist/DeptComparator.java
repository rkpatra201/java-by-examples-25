package com.example.arraylist;

import com.example.arraylist.models.Student1;

import java.util.Comparator;

public class DeptComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.department.compareTo(o2.department);
    }
}
