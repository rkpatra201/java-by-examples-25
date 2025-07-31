package com.example.app;

import com.example.config.AppConfig;
import com.example.dao.LogDao;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserDao userDao = context.getBean(UserDao.class);
        LogDao logDao = context.getBean(LogDao.class);
        UserService userService = context.getBean(UserService.class);

        userDao.insertUser(1, "Alex");


//       DATABASE OUTPUT:-
/*
mysql> SELECT * FROM users;
+----+------+
| id | name |
+----+------+
|  1 | Alex |
+----+------+
1 row in set (0.01 sec)

mysql> SELECT * FROM logs;
Empty set (0.00 sec)
*/

        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        userService.updateUserWithLog(1, "Bob", false);
        System.out.println("User: " + userDao.getUser(1));   //Bob
        System.out.println("Logs: " + logDao.getLogs());    //[Updated user 1 [failAfterLog- false]]

        try {
            userService.updateUserWithLog(1, "Charlie", true);
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());   //Simulated failure after log
        }

        System.out.println("User after rollback: " + userDao.getUser(1));  //Bob
        System.out.println("Logs after rollback: " + logDao.getLogs());   //[Updated user 1 [failAfterLog- false], Updated user 1 [failAfterLog- true]]


//     DATABASE OUTPUT:-
/*
mysql> SELECT * FROM users;
+----+------+
| id | name |
+----+------+
|  1 | Bob  |
+----+------+
1 row in set (0.01 sec)

mysql> SELECT * FROM logs;
+----+-------------------------------------+
| id | message                             |
+----+-------------------------------------+
|  1 | Updated user 1 [failAfterLog- false] |
|  2 | Updated user 1 [failAfterLog- true]  |
+----+-------------------------------------+
2 rows in set (0.00 sec)
*/
        context.close();
    }
}

