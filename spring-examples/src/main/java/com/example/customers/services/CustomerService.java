package com.example.customers.services;

import com.example.customers.daos.CustomerRepository;
import com.example.customers.models.Customer;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        System.out.println(this.getClass()+" "+customer);
        customerRepository.save(customer);
    }

}
