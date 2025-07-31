package com.example.student.controller;

import com.example.student.service.StudentService;

public class StudentController {
    private StudentService studentService ;
    public StudentController (StudentService studentService){
        this.studentService = studentService ;
    }

    public void registerStudent(){
        System.out.println("student service");
        studentService.resister();
    }
}
