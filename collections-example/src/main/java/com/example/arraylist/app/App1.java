package com.example.arraylist.app;

import com.example.arraylist.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class App1 {
    public static void main(String[] args) {

        // wrapper type
        Logger logger = LoggerFactory.getLogger(App1.class);
        List<Integer> list = new ArrayList<>();

        // add() use case
        list.add(10);
        list.add(11);
        list.add(12);
        logger.info(list.toString());

        //get() use case
        logger.info(String.valueOf(list.get(1)));

        // update use case
        list.set(2 , 20);
        logger.info(list.toString());

        // check if present using contains
        logger.info(String.valueOf(list.contains(1)));

        //delete only selected index use case
        list.remove(1);
        logger.info(list.toString());


        //delete the list case
        list.clear();
        logger.info(list.toString());


        // abstract data type
        List<Employee> employeesList = new ArrayList<>();

        // add() use case
        employeesList.add(new Employee(100,"john","san fransisco"));
        employeesList.add(new Employee(101,"alice","indiana"));
        logger.info(employeesList.toString());

        //get() use case
        logger.info(String.valueOf(employeesList.get(1)));

        // update use case
        employeesList.set(1 , new Employee(102,"sumit","bhubaneswar"));
        logger.info(employeesList.toString());

        // delete selected index
        employeesList.remove(1);
        logger.info(employeesList.toString());

    }
}
