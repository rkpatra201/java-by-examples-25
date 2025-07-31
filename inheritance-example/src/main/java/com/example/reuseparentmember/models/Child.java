package com.example.reuseparentmember.models;

public class Child extends Parent{
     public int num1 =14;

     public int getNum1(int num1){
         return this.num1 = num1 ;
     }

     public void childProperty(){
          System.out.println("child has 1acre of filds");
     }
}
