package com.example.reuseparentmember.app;

import com.example.reuseparentmember.models.Child;
import com.example.reuseparentmember.models.Parent;

//reuse parent members in child class
public class App1 {
    public static void main(String[] args) {

        // state

        // parent reference but object is child expected o/p : 15
        Parent parent =new Child();

        // Child reference and object is child expected o/p : 14
        Child child =new Child();

        System.out.println(child.num1);
        System.out.println(parent.num1);

        // two different object will create
        System.out.println(parent);
        System.out.println(child);

        parent.num1 = 20 ;
        child.num1 = 21 ;

        System.out.println(child.num1);
        System.out.println(parent.num1);


        int parent1 = parent.getNum1(20);
        int child1 = child.getNum1(20);

        System.out.println("child getter:"+child1);
        System.out.println("parent getter:"+parent1);


        // behaviour
        child.childProperty();
        child.parentPropety();    // calling parent through child
    }
}
/*
* Q) Does creating child class object create parent class object.
* A) No, creating an instance of a child class does not create a separate instance of the parent class.
*    Instead, the child class object is an instance of both the child class and the parent class,
*    inheriting the parent's properties and methods.
*
* follow above example
* */

/*
*  Q) Can variables overridden.
*  A) variables cannot be overridden .
*    When a subclass declares a variable with the same name as a variable, in its
*    superclass, it hides the superclass's variable rather than overriding it
 *   This is known as variable hiding.Variable hiding means that when you access
 *   the variable using a reference of the subclass type, you get the subclass's variable.
 *   However, when you access the variable using a reference of the superclass type, you get
 *   the superclass's variable.
 *
 *   follow above example
 * */
