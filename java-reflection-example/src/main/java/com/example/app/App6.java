package com.example.app;

import java.lang.reflect.Field;

public class App6 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyClass myClass = new MyClass();
        Class field = MyClass.class ;

        // access field
        Field field1 = field.getField("num1");
        System.out.println(field1);

        // field name
        String field2 = field.getName();
        System.out.println(field2);

        // get field
        Object value = field1.get(myClass);
        System.out.println(value);

        // set field
        field1.set(myClass , 11);

    }
}

class MyClass{
    public int num1 = 10 ;
    String name = "Biswajit";
}
