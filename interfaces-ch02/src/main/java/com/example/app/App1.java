package com.example.app;

import com.example.contracts.Animal;
import com.example.models.Cat;
import com.example.models.Dog;

public class App1 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        Cat myCat = new Cat();

        System.out.println("--- Dog ---");
        myDog.eat();   //Dog is eating
        myDog.sleep();  //Dog is sleeping

        System.out.println("\n--- Cat ---");
        myCat.eat();  //Cat eats fish.
        myCat.sleep();  //Cat sleeps on the sofa.
        myCat.play();   //Cat plays with a ball.
        myCat.beFriendly();  //Cat is very friendly.
        myCat.fly();
    }
}
