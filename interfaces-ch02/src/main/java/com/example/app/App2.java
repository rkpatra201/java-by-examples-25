package com.example.app;

import com.example.contracts.Animal;
import com.example.models.Cat;
import com.example.models.Dog;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your pet (dog/cat): ");
        String choice = scanner.nextLine();

        Animal myPet;

        if (choice.equalsIgnoreCase("dog")) {
            myPet = new Dog();
        } else if (choice.equalsIgnoreCase("cat")) {
            myPet = new Cat();
        } else {
            System.out.println("Invalid choice. Defaulting to dog.");
            myPet = new Dog();
        }

        myPet.eat();
        myPet.sleep();
    }
}
