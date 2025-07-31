package com.example.twodarray.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Slf4j
public class App1 {
    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(App1.class);

        //
        /*
        * declaring array : int [][] arr = new int[row][columns]
        *
        * */
        int [][] arr = new int[2][3];
        logger1.info(String.valueOf("rows: " +arr.length));
        logger1.info(String.valueOf("columns: " +arr[0].length));

        // declaring and initializing 2D array
        int [][] arr1 = {{1,2,3},{4,5,6}};

        // Arrays.deepToString(arr1) is designed to print content of 2-d array
        logger1.info(Arrays.deepToString(arr1));
    }
}
