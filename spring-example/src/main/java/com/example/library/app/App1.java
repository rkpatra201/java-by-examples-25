package com.example.library.app;

import com.example.library.controller.LibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("library.xml");
        LibraryController libraryController = (LibraryController) context.getBean("libraryController");
        libraryController.registerStudent();
    }
}
