package com.example.implemetationexample.app;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int [] result = segregateNumber(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int [] segregateNumber(int[] array){
        int start = 0 ;
        int end = array.length-1;

        while (start<= end ){
            if(array[start]%2==0){
                start++;
            }
            else if (array[end]%2==1){
                end--;
            }
            else {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp ;
                start++ ;
                end -- ;
            }
        }
        return array ;
    }
}
