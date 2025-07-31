package com.example.customer.controller;

import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;

public class CustomerController {
    private CustomerService customerService;

    public void createCustomer(Customer c){
        System.out.println(this.getClass()+ " : " + c);
        customerService.createCustomer(c);
    }
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
