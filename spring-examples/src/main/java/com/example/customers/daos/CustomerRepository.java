package com.example.customers.daos;

import com.example.customers.models.Customer;

public class CustomerRepository {
    private Customer customer;

    public void save(Customer c){
        System.out.println("Customer: " +c);
    }
}
