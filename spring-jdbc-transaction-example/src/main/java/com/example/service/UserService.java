package com.example.service;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LogService logService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserWithLog(int id, String name, boolean failAfterLog) {
        userDao.updateUser(id, name);
        logService.log("Updated user " + id + " [failAfterLog- "+ failAfterLog + "]");

        if (failAfterLog) {
            throw new RuntimeException("Simulated failure after log");
        }
    }
}
