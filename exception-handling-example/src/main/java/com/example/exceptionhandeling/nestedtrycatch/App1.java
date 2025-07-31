package com.example.exceptionhandeling.nestedtrycatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App1 {
    public static void main(String[] args) {
      m1();
    }
    private static void m1(){
        try {
            int result = 10/0;
            System.out.println("evaluate expression ");
            System.out.println("file reading start ");

            File f = new File("abc.txt");
            FileInputStream fileInputStream = new FileInputStream(f);
            System.out.println("file reading complete");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("AE occurred");
        }catch (FileNotFoundException f) {
            f.printStackTrace();
            System.out.println("FNFE occurred");
        }
    }
}
