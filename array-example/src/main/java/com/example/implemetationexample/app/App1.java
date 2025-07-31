package com.example.implemetationexample.app;

// finding target index using binary search
public class App1 {
    public static void main(String[] args) {

        int [] arr = {-1,2,4,5,6,7};
        int target = 7 ;
//        BinarySearch b1 = new BinarySearch();
        int result = searchTarget(arr,target);
        System.out.println("target index is: "+result);
    }

    private static int searchTarget(int[] arr ,int target ){

        int start = 0 ;
        int end = arr.length-1;


        while (start<=end){
            int mid = (start+end)/2 ;
            if (target>arr[mid]){
                start = mid+1 ;
            } else if (target<arr[mid]) {
                end = mid-1 ;
            }
            else
                return mid ;
        }
        return -1;
    }
}
