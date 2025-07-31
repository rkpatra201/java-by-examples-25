package com.example.strategy.models;


import com.example.strategy.contracts.PaymentStrategy;

public class DebitCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using debit Card.");
    }
}
