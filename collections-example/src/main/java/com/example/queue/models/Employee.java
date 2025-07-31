package com.example.queue.models;

public class Employee {

    public int id ;
    public String name ;

    public Employee(int id , String name ){
        this.id = id ;
        this.name = name ;
    }

//    @Override
//    public int

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
