package com.example.customer.service;

import com.example.customer.daos.CustomerRepository;
import com.example.customer.models.Customer;

public class CustomerService {
    private CustomerRepository customerRepository ;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer c){
        System.out.println(this.getClass() +" "+ c );
        customerRepository.save(c);
    }

    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
}
