package com.example.library.service;

import com.example.library.repository.LibraryRepository;

public class LibraryService {
    private LibraryRepository libraryRepository ;

    public void setLibraryRepository(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository ;
    }

    public void register(){
        System.out.println("total 100 books are available for rent");
        libraryRepository.storedDetail();
    }
}
