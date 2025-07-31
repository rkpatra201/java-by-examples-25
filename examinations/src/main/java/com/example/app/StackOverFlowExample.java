package com.example.app;

import java.util.logging.Logger;

public class StackOverFlowExample {
    public static Logger logger = Logger.getLogger(StackOverFlowExample.class.getName());
    public static void main(String[] args) {
        try {

            recursiveMethod();
        } catch (StackOverflowError e){
            logger.warning("Stack Overflow...");
        }
    }

    private static void recursiveMethod() {
        recursiveMethod();
    }
}
