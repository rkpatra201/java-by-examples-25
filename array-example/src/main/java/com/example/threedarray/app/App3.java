package com.example.threedarray.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App3 {
    public static void main(String[] args) {
        int [][][] treeDArray= {{{1,2},{3,4}},
                                {{10,15},{18,19}}
                               };
        int element2 = treeDArray[0][0][0];
        int element7 = treeDArray[1][0][0];
        int element3 = treeDArray[0][1][0];
        int element4 = treeDArray[0][1][1];
        int element =  treeDArray[1][0][1];
        int element1 = treeDArray[0][0][1];
        int element5 = treeDArray[1][1][1];
        int element6 = treeDArray[1][1][0];
        log.info(String.valueOf(element2));
        log.info(String.valueOf(element1));
        log.info(String.valueOf(element3));
        log.info(String.valueOf(element4));
        log.info(String.valueOf(element7));
        log.info(String.valueOf(element));
        log.info(String.valueOf(element6));
        log.info(String.valueOf(element5));
    }
}
