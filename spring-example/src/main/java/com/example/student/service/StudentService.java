package com.example.student.service;

import com.example.student.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }

    public void resister(){
        System.out.println("registering students ...");
        studentRepository.save();
    }
}
