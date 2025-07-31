package com.example.models;

public class Employee {
        private int id;
        private double salary;
        private String name;

        enum Week{
            SUN,TUE,WED;
        }

        @interface MyAnnotation{}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Employee() {
    }
}
