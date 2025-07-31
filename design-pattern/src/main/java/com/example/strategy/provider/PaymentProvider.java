package com.example.strategy.provider;


import com.example.strategy.contracts.PaymentStrategy;
import com.example.strategy.models.CrediCardPayment;
import com.example.strategy.models.DebitCardPayment;

public class PaymentProvider {
    private String cardType;

    public PaymentProvider(String cardType) {
        this.cardType = cardType.toLowerCase();
    }

    public PaymentStrategy getPaymentStrategy() {
        switch (cardType) {
            case "debitcard":
                return new CrediCardPayment();
            case "creditcard":
                return new DebitCardPayment();
            default:
                throw new IllegalArgumentException("Unsupported card type: " + cardType);
        }
    }
}

