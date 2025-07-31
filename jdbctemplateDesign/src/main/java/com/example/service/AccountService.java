package com.example.service;

import com.example.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void outerTransaction() {
        accountDao.addAccount("OuterUser", 5000);
        System.out.println("Outer transaction: Added OuterUser");

//        try {
//            innerTransaction();
//        } catch (Exception e) {
//            System.out.println("Inner transaction rolled back: " + e.getMessage());
//        }
//
//        throw new RuntimeException("Forcing rollback in outer transaction");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void innerTransaction() {
        accountDao.addAccount("InnerUser", 1000);
        System.out.println("Inner transaction: Added InnerUser");

        throw new RuntimeException("Forcing rollback in inner transaction");
    }
}
