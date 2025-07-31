package com.example.arraylist.models;

public class Student {
    public String name ;

    public Student(String name){
        this.name = name ;
    }

    public Student(Student newName){
        this.name = newName.name;
    }

    // override clone() for Object class to support deep copy
    @Override
    public Student clone(){
        return new Student(this.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
