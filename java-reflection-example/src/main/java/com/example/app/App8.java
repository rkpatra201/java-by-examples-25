package com.example.app;

import java.lang.annotation.*;

// This annotation specifies how long annotations are retained.
// RUNTIME means the annotation is available during runtime for reflection.
@Retention(RetentionPolicy.RUNTIME)

// Specifies where the annotation can be applied. ElementType.TYPE means it can be applied to classes, interfaces, enums.
@Target({ElementType.METHOD, ElementType.TYPE})

// My custom annotation
@interface MyAnnotation {
    public String name();
    public String value();
}

// Class Annotation example
@MyAnnotation(name = "Biswajit", value = "Java Developer")
public class App8 {
    public static void main(String[] args) {
        Class aClass = App8.class;
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}
