package com.example.adaptor.models;

import com.example.adaptor.contracts.Iphone;

public class ChargeAdapter implements Iphone {

    private AndroidCharger androidCharger;

    public ChargeAdapter(AndroidCharger androidCharger){
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeWithIphone() {
        System.out.println("charging iphone by android charger ");
        androidCharger.chargeWithAndroid();
    }
}

