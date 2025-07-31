package com.example.models;

public class Book {
    String title;
    String author;
    public Book(){
        System.out.println("This is default constructor.");
        title = "Default Book";
        author = "Default Author";

    }

    public Book(String book){
        this();  //This is default constructor.
        System.out.println("This is single parametrized constructor");
    }

    public Book(String t, String a){
        this("Single parameter Book"); // This is single parametrized constructor. This is single parametrized constructor
        System.out.println("This is two parameterized constructor.");
        this.title = t;
        this.author = a;
        this.displayInfo(); //  Title: Book2, Author: Author2
    }
    public void displayInfo(){
        System.out.println("Title: "+ title + ", Author: "+ author);
    }

}
