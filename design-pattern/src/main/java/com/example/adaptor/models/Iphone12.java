package com.example.adaptor.models;

import com.example.adaptor.contracts.Iphone;

public class Iphone12 implements Iphone {
    @Override
    public void chargeWithIphone(){
        System.out.println("charging iphone with iphone charger");
    }
}
