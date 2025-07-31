package com.example.arraylist.models;

public class Student1 {
    public String name ;
    public Integer id ;
    public String department ;

    public Student1(int id , String name , String department){
        this.id = id ;
        this.name = name ;
        this.department = department ;
    }
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
