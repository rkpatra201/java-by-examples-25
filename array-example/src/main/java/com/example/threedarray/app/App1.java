package com.example.threedarray.app;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class App1 {
    public static void main(String[] args) {
        // 3-d array declaration and initialization
        int [][][] threeDArray = {{{1,2},{3,4}},
                                 {{5,6},{7,8}}};
        log.info(Arrays.deepToString(threeDArray));
    }
}
