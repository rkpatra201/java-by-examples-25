package com.example.exceptionhandeling.nestedtrycatch;

import java.io.FileInputStream;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) {
        FileInputStream is = null;
        try {
            System.out.println("try-1");
            is = new FileInputStream("abc.txt");
        }
        catch (Exception e) {
           e.printStackTrace();
            System.out.println("catch-1");
        }
        finally {
            try {
                is.close();
                System.out.println("try-2");
            } catch (NullPointerException n) {
                System.out.println("NPE-catch");
            } catch (IOException e) {
                System.out.println("IOE-catch");;
            }finally {
                System.out.println("finaly-2");
            }
        }

    }
}
