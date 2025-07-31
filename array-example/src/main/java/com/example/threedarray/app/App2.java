package com.example.threedarray.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
    public static void main(String[] args) {
        int [][][] threeDArray = {{{1,2},{3,4}},{{5,6},{7,8}}};

        log.info("using for loop");
        int depth = threeDArray.length;
        int row = threeDArray[0].length;
        int column = threeDArray[0][0].length;

        for (int i = 0 ; i<depth ; i++){
            for (int j =0 ; j<row ; j++){
                for (int k =0 ; k<column ; k++){
                    log.info(String.valueOf(threeDArray[i][j][k]));
                }
            }
        }

        log.info("-------------------");
        log.info("using for each loop");

        for (int[][] twoDArray : threeDArray) {
            for (int[] oneDArray : twoDArray) {
                for (int element : oneDArray) {
                    log.info(String.valueOf(element));
                }
            }
        }

        log.info("-------------------");
        log.info("using while loop");
        int index =0 ;

        while(index < depth){
            int j = 0;
            while (j< row){
                int k = 0;
                while (k<column){
                    log.info(String.valueOf(threeDArray[index][j][k]));
                    k++;
                }
                j++;
            }
            index++;
        }

        log.info("-------------------");
        log.info("using do while loop");
        int index1 =0 ;

        do {
            int j = 0;
            do {
                int k = 0;
                do {
                    log.info(String.valueOf(threeDArray[index1][j][k]));
                    k++;
                } while (k < column);
                j++;
            } while (j < row);
            index1++;
        } while (index1 < depth);



    }
}
