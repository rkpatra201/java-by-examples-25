package com.example.bank.service;

import com.example.bank.daos.BankRepository;
import com.example.bank.models.BankAccount;

public class BankService {
    private BankRepository bankRepository ;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void debitCardTransaction(BankAccount bankAccount){
        System.out.println(bankAccount);
        bankRepository.accountDetails(bankAccount);
    }

    public void creditCardTransaction(BankAccount bankAccount){
        System.out.println(bankAccount);
        bankRepository.accountDetails(bankAccount);
    }
}
