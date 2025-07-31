package com.example.customanotation;

import com.example.customanotation.ValidateParams;
import org.springframework.stereotype.Component;

@Component
public class AopCustomExample {

    @ValidateParams
    public void show(String name, int age) {
        System.out.println("Inside show: name = " + name + ", age = " + age);
    }
}

