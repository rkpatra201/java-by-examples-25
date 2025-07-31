package com.example.strategy.models;


import com.example.strategy.contracts.PaymentStrategy;

public class CrediCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}