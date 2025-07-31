package com.example.controller;

import com.example.daos.StudentRepository;
import com.example.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

    @PostMapping("/student/add")
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("Jack");
        student.setPercentage(95);
        repo.save(student);
        return student;
    }

    @DeleteMapping("student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        repo.deleteById(id);
    }
}
