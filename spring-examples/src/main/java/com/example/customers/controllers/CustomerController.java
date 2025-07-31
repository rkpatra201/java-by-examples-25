package com.example.customers.controllers;

import com.example.customers.models.Customer;
import com.example.customers.services.CustomerService;

public class CustomerController {
    private CustomerService customerService;

    public void createCustomer(Customer customer){
        System.out.println(this.getClass()+" "+ customer);
        customerService.createCustomer(customer);
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
