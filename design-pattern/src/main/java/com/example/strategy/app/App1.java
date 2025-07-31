package com.example.strategy.app;
import com.example.strategy.contracts.PaymentStrategy;
import com.example.strategy.provider.PaymentProvider;

public class App1 {
    public static void main(String[] args) {
        // Simulating "external" decision of which card is used
        PaymentProvider paymentProvider = new PaymentProvider("debitcard");

        // Business logic knows only about the abstraction
        PaymentStrategy payment = paymentProvider.getPaymentStrategy();
        payment.pay(1000); // Output: Paid ₹1000 using Visa Credit Card.
    }
}
