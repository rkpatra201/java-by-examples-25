package com.example.student.app;


import com.example.student.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//
public class App1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentController controller = (StudentController) context.getBean("studentController");
        controller.registerStudent();
    }
}
