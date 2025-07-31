package com.example.implemetationexample.app;

public class App2 {
    public static void main(String[] args) {
        int[] arr = {10,15,98,1,2};
        int maxResult = findMax(arr);
        System.out.println(maxResult);
        int minResult = findMinElement(arr);
        System.out.println(minResult);
    }
    private static int findMax(int []array){

        int len = array.length-1;
        int max = array[0];
        for (int i =1 ; i<len ; i++){
            if (max>array[i]){
                max = array[i];
                return max ;
            }
        }
        return -1 ;
    }
    private static int findMinElement(int []array){
        int len = array.length-1;
        int min = array[0];
        for (int i = 1 ; i<len ;i++){
            if (min < array[i]){
                min = array[i];
                return min;
            }
        }
        return -1;
    }
}
