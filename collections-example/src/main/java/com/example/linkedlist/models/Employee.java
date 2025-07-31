package com.example.linkedlist.models;

public class Employee {
    public int id ;
//    public String name ;
//    public String dpmt ;

    public Employee(int id){
        this.id = id ;
//        this.name = name ;
//        this.dpmt = dpmt ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
//                ", name='" + name + '\'' +
//                ", dpmt='" + dpmt + '\'' +
                '}';
    }
}