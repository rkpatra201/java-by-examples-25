package com.example.app;


import com.example.config.AppConfig;
import com.example.dao.AccountDao;
import com.example.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDao accountDao = context.getBean(AccountDao.class);
        AccountService accountService = context.getBean(AccountService.class);

        accountDao.createTable();

        try {
            accountService.outerTransaction();
        } catch (Exception e) {
            System.out.println("Outer transaction rolled back: " + e.getMessage());
        }

        context.close();
    }
}

