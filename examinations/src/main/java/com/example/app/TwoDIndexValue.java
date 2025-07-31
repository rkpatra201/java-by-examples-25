package com.example.app;

import java.util.Scanner;

public class TwoDIndexValue {
    public static void main(String[] args) {
        int[][] arr = {{10,11,12}, {13,14,15}, {16,17,18}};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the valid index number[0, 8]: ");
        int index = sc.nextInt();
        System.out.println("The index value: "+getValueByIndex(index,arr));
        int[] position = getPosition(index,arr);
        getValueByPosition(position,arr);
    }

    private static int getValueByIndex(int index, int[][] arr) {
        int i, j;
        i = index / arr[0].length;
        j = index % arr[0].length;
        return arr[i][j];
    }

    private static int[] getPosition(int index, int[][] arr) {
        int i, j;
        i = index / arr[0].length;
        j = index % arr[0].length;
        System.out.println("The index position is: ["+i+"]["+j+"]");
        int[] num = {i, j};
        return num;
    }
    private static void getValueByPosition(int[] position, int[][] arr) {
        int first = position[0];
        int second = position[1];
        System.out.println("The position value: "+arr[first][second]);
    }

}
