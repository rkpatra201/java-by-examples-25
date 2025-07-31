package com.example.app;

import com.example.models.Student;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
        System.out.println("This is an example of primitive parameterized method: ");
        Student st1 = new Student();
        System.out.println(st1.studentName("John Doe"));
        System.out.println();

        System.out.println("This is an example of Object parameterized method: ");
        Student st2 = new Student("Jack Sparrow");
        objectParameterexample(st2);
        System.out.println();

        System.out.println("This is an example of Array parameterized method: ");
        int[] rollNumber = {12,34, 37, 55, 02};
        arrayParameterexample(rollNumber);


    }
    static void objectParameterexample(Student student){
        System.out.println(student.name);
    }

    static void arrayParameterexample(int[] arr){
        System.out.println("Student Rollnumbers: ");
        Arrays.sort(arr);
        for (int i = 0; i< arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
