package com.example.customers.app;

import com.example.customers.config.DatabaseConfig;
import com.example.customers.controllers.CustomerController;
import com.example.customers.models.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer.xml");
        CustomerController customerController = applicationContext.getBean(CustomerController.class);
        Customer customer = new Customer(1,"Max","USA");
        customerController.createCustomer(customer);

        DatabaseConfig databaseConfig = applicationContext.getBean(DatabaseConfig.class);
        System.out.println(databaseConfig);
    }
}
