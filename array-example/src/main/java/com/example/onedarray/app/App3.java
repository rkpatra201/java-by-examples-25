package com.example.onedarray.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

// accessing array by index
@Slf4j
public class App3 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App3.class);
        int[] myArray = {10, 20, 30, 40, 50};
        int element = myArray[2]; // Accessing the element at index 2 (which is 30)
        logger.info(String.valueOf(element));
    }
}
