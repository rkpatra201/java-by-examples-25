package com.example.models;

import com.example.contracts.Animal;
import com.example.contracts.Pet;

public class Cat implements Animal, Pet {

    @Override
    public void eat() {
        System.out.println("Cat eats fish.");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeps on the sofa.");
    }

    @Override
    public void play() {
        System.out.println("Cat plays with a ball.");
    }

    @Override
    public void beFriendly() {
        System.out.println("Cat is very friendly.");
    }
    @Override
    public void fly(){
        System.out.println("Cat can't fly.");
    }
}

