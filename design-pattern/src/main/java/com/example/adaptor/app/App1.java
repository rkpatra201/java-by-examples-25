package com.example.adaptor.app;


import com.example.adaptor.contracts.Iphone;
import com.example.adaptor.models.AndroidCharger;
import com.example.adaptor.models.ChargeAdapter;

public class App1 {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        Iphone iphone = new ChargeAdapter(androidCharger);
        iphone.chargeWithIphone();
    }
}

