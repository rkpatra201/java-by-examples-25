package com.example.twodarray.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
    public static void main(String[] args) {
        int [][] twoDArray = {{1,2},{3,4}};

        log.info("using for loop");
        int row = twoDArray.length;
        int column = twoDArray[0].length;

        for (int i = 0 ; i<row ; i++){
            for (int j =0 ; j<column ; j++){
                    log.info(String.valueOf(twoDArray[i][j]));
            }
        }

        log.info("-------------------");
        log.info("using for each loop");

            for (int[] oneDArray : twoDArray) {
                for (int element : oneDArray) {
                    log.info(String.valueOf(element));
                }
            }

        log.info("-------------------");
        log.info("using while loop");

            int j = 0;
            while (j< row){
                int k = 0;
                while (k<column){
                    log.info(String.valueOf(twoDArray[j][k]));
                    k++;
                }
                j++;
            }


        log.info("-------------------");
        log.info("using do while loop");

            int index = 0;
            do {
                int k = 0;
                do {
                    log.info(String.valueOf(twoDArray[index][k]));
                    k++;
                } while (k < column);
                index++;
            } while (index < row);

    }
}
