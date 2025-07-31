package com.example.onedarray.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Slf4j
public class App1 {
    public static void main(String[] args) {
        // array declaration syntax
        Logger logger = LoggerFactory.getLogger(App1.class);
        logger.info("type-1");
        /*
        *  array declaration and initialization in same line
        * The array is created with a fixed size of 3 and explicitly initialized with the values 1, 2, and 3.
        * Memory is allocated and filled with those values.
        * resulting array arr[0] = 1 , arr[1] = 2 ,arr[2] = 3
        * Arrays.toString(arr) is designed for one-dimensional arrays . it will only print content for
        * 1-d array content.
        * */
        int [] arr = {1,2,3};
        logger.info(Arrays.toString(arr));

        logger.info("type-2");

        /*
         * Declaration and initialization are separate.
         * new int[5] creates an array with a fixed size of 10.
         * All elements are automatically initialized to 0, the default value for int.
         *
         * */

        int [] array2 ;
        array2 = new int[5];
        logger.info(Arrays.toString(array2));

        logger.info("type-3");

        /*
         * Declares an array named array3 of type int[].
         * Allocates memory for 10 integers.
         * All elements are automatically initialized to 0, the default value for int.
         *
         * */

        int [] array3 = new int[10];
        logger.info(Arrays.toString(array3));


        // similarly other primitive type

        logger.info("byte type");
        byte[] anArrayOfBytes = new byte[10];
        logger.info(Arrays.toString(anArrayOfBytes));

        logger.info("sort type");
        short[] anArrayOfShorts = new short[5];
        logger.info(Arrays.toString(anArrayOfShorts));

        logger.info("long type");
        long[] anArrayOfLongs = new long[5];
        logger.info(Arrays.toString(anArrayOfLongs));

        logger.info("float type");
        float[] anArrayOfFloats = new float[5];
        logger.info(Arrays.toString(anArrayOfFloats));

        logger.info("double type");
        double[] anArrayOfDoubles = new double[5];
        logger.info(Arrays.toString(anArrayOfDoubles));

        logger.info("boolean type");
        boolean[] anArrayOfBooleans = new boolean[5];
        logger.info(Arrays.toString(anArrayOfBooleans));

        logger.info("double type");
        char[] anArrayOfChars = {'a','b','c','d'};
        logger.info(Arrays.toString(anArrayOfChars));


    }
}
