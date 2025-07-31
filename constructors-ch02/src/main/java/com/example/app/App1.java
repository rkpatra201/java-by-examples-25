package com.example.app;

import com.example.models.Book;

public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(); //This is default constructor.
        Book book2 = new Book("Book2","Author2");
        book1.displayInfo();  //Title: Default Book, Author: Default Author
//        book2.displayInfo();
    }
}
