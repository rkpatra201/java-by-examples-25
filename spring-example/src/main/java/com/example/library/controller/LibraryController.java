package com.example.library.controller;

import com.example.library.service.LibraryService;

public class LibraryController {
    private LibraryService libraryService;

    // constructor injection
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService ;
    }
    public void registerStudent(){
        System.out.println("50 students register for book ");
        libraryService.register();
    }
}
