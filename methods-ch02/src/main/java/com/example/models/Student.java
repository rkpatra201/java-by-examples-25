package com.example.models;

public class Student {
    public String name;

    public Student(){

    }
    public Student(String name){
        this.name = name;
    }
    public String studentName(String str){
        System.out.println("This is a non static method...");
        System.out.println("Student name: ");
        return str;
    }

    public static int studentCount(int num){
        System.out.println("This is a static method...");
        System.out.println("Student count: ");
        return num;
    }

    public void studentDescription(){
        System.out.println("This is non parameter method.");
        System.out.println("Name- John Doe, Class- 6th, Roll number- 54");
    }
    public void studentDescription(String nm, int cls, int roll){
        System.out.println("Welcome to Greenfield school");
        showDescription(nm, cls, roll);
    }

    public void showDescription(String nm, int cls, int roll){
        System.out.println("This is " + nm
                + " from " + cls
                + "th class having roll number " + roll);
    }
}
