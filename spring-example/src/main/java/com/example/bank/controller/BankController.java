package com.example.bank.controller;

import com.example.bank.models.BankAccount;
import com.example.bank.service.BankService;

public class BankController {
     private BankService bankService ;

     public void creditCardTransaction(BankAccount bankAccount){
         System.out.println(bankAccount);
         bankService.debitCardTransaction(bankAccount);
     }

     public void debitCardTransaction(BankAccount bankAccount){
         System.out.println(bankAccount);
         bankService.debitCardTransaction(bankAccount);
     }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
}
