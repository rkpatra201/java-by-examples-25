package com.example.queue.app;

import com.example.queue.models.Employee;

import java.util.LinkedList;
import java.util.Queue;

public class App1 {
    public static void main(String[] args) {
        Queue<Employee> employeeQueue = new LinkedList<>();

        // add element to the queue if it is full it returns exception
        employeeQueue.add(new Employee(100,"john"));
        employeeQueue.add(new Employee(101,"rockey"));
        employeeQueue.add(new Employee(102,"jack"));

        System.out.println("element in the queue:"+employeeQueue);

        // offer() : also add element to the rear of queue but if it is full then it returns false instead
        employeeQueue.offer(new Employee(103 , "soha"));
        System.out.println("add new element using offer() :"+employeeQueue);

       // fetch the top element of the queue
        System.out.println("fetch top element using peek() :"+employeeQueue.peek());

        // remove element from queue using remove() : it throws exception when empty
        employeeQueue.remove();
        System.out.println("remove top element for queue:"+employeeQueue);

        // remove using poll() : but it return null when empty
        employeeQueue.poll();
        System.out.println("remove the top element form the queue using poll() :"+employeeQueue);

        // returns no of element present in the queue
        System.out.println("size of the queue:"+employeeQueue.size());

        employeeQueue.clear();
        System.out.println("delete all element for the queue:"+employeeQueue);

        // now it will show exception : NoSuchElementException
        try {
            employeeQueue.remove();
        } catch (Exception e) {
            System.out.println("NoSuchElementException");;
        }

        // check queue is empty or not using isEmpty()
        if (employeeQueue.isEmpty()){
            System.out.println("the queue is empty");
        }
    }
}
