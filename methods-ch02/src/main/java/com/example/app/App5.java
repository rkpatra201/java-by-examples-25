package com.example.app;

import com.example.models.Student;

public class App5 {
    public static void main(String[] args) {
//        NullPointer Exception: Null.anyNonStaticMember(method/variable)
        Student st1 = null;
        st1.studentDescription("John Doe", 7, 184);
    }
}
