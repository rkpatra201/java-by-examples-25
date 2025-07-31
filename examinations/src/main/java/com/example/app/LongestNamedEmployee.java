package com.example.app;

import com.example.models.Employee;

import java.util.logging.Logger;

public class LongestNamedEmployee {
    public static Logger logger = Logger.getLogger(LongestNamedEmployee.class.getName());
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee(1,"Alex");
        employees[1] = new Employee(2,"Bob");
        employees[2] = new Employee(3,"Max");
        employees[3] = new Employee(4,"Harry");
        Employee longestname = employees[0];
        for (int i=0; i < employees.length;i++){
            if (longestname.name.length() < employees[i].name.length()){
                longestname = employees[i];
            }
        }
        logger.info("The longest named employee Id: " + longestname.id +", name: "+ longestname.name );
    }
}
