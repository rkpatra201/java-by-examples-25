package com.example.twodarray.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App3 {
    public static void main(String[] args) {
        int [][]twoDArray = {{1,2},{4,5}};
        int element = twoDArray[0][0];
        int element1 = twoDArray[0][1];
        int element2 = twoDArray[1][0];
        int element3 = twoDArray[1][1];
        log.info(String.valueOf(element));
        log.info(String.valueOf(element1));
        log.info(String.valueOf(element2));
        log.info(String.valueOf(element3));
    }
}
