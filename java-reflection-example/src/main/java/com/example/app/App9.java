package com.example.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class TheClass {
    @MyAnnotation(name="helloAnnotation",  value = "Hello World")
    public void helloAnnotation(){}
}
// method annotation example
public class App9 {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TheClass.class.getMethod("helloAnnotation");
        Annotation[] annotations = method.getDeclaredAnnotations();

        //Checks whether the annotation object is of type MyAnnotation.
        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}
/*
* instanceof is a Java keyword used to check if an object is an instance of a specific class or interface.
* It returns true or false.
*
*
* */
