package com.example.queue.models;

public class Employee1 implements Comparable<Employee1>{
    public int id ;
    public String name ;

    public Employee1(int id , String name ){
        this.id = id ;
        this.name = name ;
    }

    @Override
    public int compareTo(Employee1 o) {
        return Integer.compare(this.id , o.id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
