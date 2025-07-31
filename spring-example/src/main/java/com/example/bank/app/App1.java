package com.example.bank.app;

import com.example.bank.controller.BankController;
import com.example.bank.models.BankAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bank.xml");
        BankController controller = applicationContext.getBean(BankController.class);
        BankAccount bankAccount = new BankAccount("credit card");
        controller.debitCardTransaction(bankAccount);
        controller.creditCardTransaction(bankAccount);

        System.out.println(bankAccount);

    }
}
