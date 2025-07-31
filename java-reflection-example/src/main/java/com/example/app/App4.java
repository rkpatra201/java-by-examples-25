package com.example.app;

import java.lang.reflect.Method;

public class App4 {
    public static void main(String[] args) {
        PublicRight publicRight = new PublicRight();
        Class implementedInterface = PublicRight.class;
        Class[] interfaces = implementedInterface.getInterfaces();
        for (Class interface1 : interfaces){
            System.out.println(interface1.getName());
        }

    }
}
interface Vehicle{
}
interface Institution{
}
interface Constitution{
}
class PublicRight implements Vehicle,Institution,Constitution{

}
