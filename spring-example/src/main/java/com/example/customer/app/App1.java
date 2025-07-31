package com.example.customer.app;

import com.example.customer.controller.CustomerController;
import com.example.customer.models.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer.xml");
        CustomerController controller = applicationContext.getBean(CustomerController.class);
        Customer c = new Customer(100 , "john" , "russia");
        controller.createCustomer(c);

    }
}
