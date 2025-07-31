package com.example.bank.daos;

import com.example.bank.models.BankAccount;

public class BankRepository {
    private BankAccount bankAccount ;
    public BankRepository(BankAccount bankAccount){
        this.bankAccount = bankAccount ;
    }
    public void accountDetails(BankAccount bankAccount){
        System.out.println("bank details is :"+ bankAccount);
    }
}
