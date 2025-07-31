package com.example.customer.app;

import com.example.customer.clients.RestClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("customer.xml");
        RestClient client = context.getBean("bean1", RestClient.class);
        System.out.println(client);

        System.out.println("--------------------------------------");

        RestClient client1 = context.getBean("bean2", RestClient.class);
        System.out.println(client1);
        ConfigurableApplicationContext cfg = (ConfigurableApplicationContext) context;
        cfg.registerShutdownHook();
    }
}
