package com.example.map.app;

import com.example.map.models.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App4 {
    public static void main(String[] args) {
        Map<Employee,String> employeeStringMap = new HashMap<>();
        employeeStringMap.put(new Employee(100,"john"),"hr");
        employeeStringMap.put(new Employee(101,"jack"),"tester");
        employeeStringMap.put(new Employee(102,"rack"),"devloper");

        // iterate over hash map of employee object
        Iterator<Map.Entry<Employee , String>> entryIterator = employeeStringMap.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Employee , String> entry = entryIterator.next();
            Employee key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key :"+ key + " value:"+ value);
        }


    }
}
