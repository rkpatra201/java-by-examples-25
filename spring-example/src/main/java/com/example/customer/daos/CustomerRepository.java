package com.example.customer.daos;

import com.example.customer.models.Customer;

public class CustomerRepository {
    private Customer customer;

    public void save(Customer c){
        System.out.println("customer :" + c);
    }
}
