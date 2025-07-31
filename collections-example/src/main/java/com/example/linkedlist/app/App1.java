package com.example.linkedlist.app;

import com.example.linkedlist.models.Employee;

import java.util.LinkedList;

// linkedList class implementation

public class App1 {
    public static void main(String[] args) {
        LinkedList<Employee> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(new Employee(100));
        integerLinkedList.add(new Employee(101));
        integerLinkedList.add(new Employee(102));

        // print linkedList
//        System.out.println(integerLinkedList);

        // insert element in first node
        integerLinkedList.addFirst(new Employee(100));
//        System.out.println(integerLinkedList);

        // insert element in last node
        integerLinkedList.addLast(new Employee(102));
//        System.out.println(integerLinkedList);

        // remove element by index from linked list
        integerLinkedList.remove(0);
//        System.out.println(integerLinkedList);

        // remove first index element from linkedList
        integerLinkedList.removeFirst();
//        System.out.println(integerLinkedList);

        // remove last indexed element from the index
        integerLinkedList.removeLast();
//        System.out.println(integerLinkedList);

        // no of element or size of linkedlist
//        System.out.println(integerLinkedList.size());

        // delete all the element from the linkedlist
        integerLinkedList.clear();
        System.out.println(integerLinkedList);

    }
}
