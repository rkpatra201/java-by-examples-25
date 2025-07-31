package com.example.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class App1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.example.models.Employee");
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Name of Constructor: " + constructor);
            System.out.println("Count of constructor parameter: " + constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter: " + parameter);
                System.out.println();
            }
            System.out.println();
        }
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Length of method : " + methods.length);

        for (Method method : methods) {
            System.out.println("Method name: " + method);
            System.out.println("Method return type : " + method.getReturnType());
            System.out.println("Method parameter count: " + method.getParameterCount());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method's Parameter: " + parameter);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
        Class[] classes = c.getDeclaredClasses();
        for (Class class1 : classes) {
            System.out.println("class: " + class1);
            System.out.println("Name of class: " + class1.getName());
            System.out.println();
        }
        Annotation[] anno = c.getDeclaredAnnotations();
        for (Annotation annotation : anno) {
            System.out.println("Annotation: " + annotation);
            System.out.println();
        }

    }


}
