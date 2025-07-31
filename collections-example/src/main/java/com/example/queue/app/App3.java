package com.example.queue.app;

import com.example.queue.models.Employee;
import com.example.queue.models.Employee1;

import java.util.PriorityQueue;
import java.util.Queue;

public class App3 {
    public static void main(String[] args) {
        Queue<Employee1> priorityQueue = new PriorityQueue<>();

        // add element to the priority queue

        priorityQueue.offer(new Employee1(600,"tyrese"));
        priorityQueue.offer(new Employee1(601,"hali"));
        priorityQueue.offer(new Employee1(602,"jylin"));
        priorityQueue.offer(new Employee1(603,"lu"));

        System.out.println(priorityQueue);




    }
}
