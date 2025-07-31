package com.example.models;

public class Employee implements Comparable<Employee>{
    public int id;
    public String name;
    public String city;
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Employee(int id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }
    @Override
    public String toString() {
        return id+ "-"+name + "-" + city ;
    }
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(other.id, this.id);  // reverse order
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
