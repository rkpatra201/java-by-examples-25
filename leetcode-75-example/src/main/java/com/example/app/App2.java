package com.example.app;

import java.util.Arrays;

// rotate array
public class App2 {
    public static void main(String[] args) {
       int [] givenArray = {1,2,3,4,5,6};
       int pos = 5 ;
       int [] resultArrayAfterRotate = rotateArray(givenArray , pos);
        System.out.println(" the result rotate array is :" + Arrays.toString(resultArrayAfterRotate));
    }
    private static int [] rotateArray(int [] originalArray , int position ){

        // rotate array by position
        int len = originalArray.length-1 ;

        if(position<= len){
            for (int i = 0 ; i<position; i++){
                for (int j = 0 ;j<len ; j++) {
                    int temp ;
                    temp = originalArray[j];
                    originalArray[j]= originalArray[len];
                    originalArray[len] = temp ;
                }
            }
        }
      return originalArray;
    }
}
