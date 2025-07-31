package com.example.app;

import java.util.logging.Logger;

public class MaxMinExample {
    public static Logger logger = Logger.getLogger(MaxMinExample.class.getName());
    public static void main(String[] args) {
        int[] num = {12,33,9,78, 55, 33, -5};
        int min = num[0];
        int max = num[0];
        for (int i =0; i < num.length ; i++){
            if (num[i] < min){
                min = num[i];
            }
            if (num[i]>max){
                max = num[i];
            }
        }
        logger.info("Max: "+ max);
        logger.info("Min: "+ min);
    }
}
