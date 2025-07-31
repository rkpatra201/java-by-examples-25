package com.example.onedarray.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
    public static void main(String[] args) {
        int [] iteratingArrayUsingFor = {1,2,3};
        int len = iteratingArrayUsingFor.length ; // finding length using .length object method .

        //iterate using for loop
        for (int i = 0 ; i<len ; i++){

            /*
            * String.valueOf() converts the value (which could be an int, char, etc.) to a String.
            * This is required because log.info(...) expects a string argument.
            * */
            log.info(String.valueOf(iteratingArrayUsingFor[i]));
        }

        log.info(("------------------"));
        log.info(("using for each loop"));
        // iterate using for each loop
        for(int e : iteratingArrayUsingFor){
            log.info(String.valueOf(e));
        }

        log.info(("------------------"));
        log.info(("using while loop"));
        int index = 0;
        while (index<len){
            log.info(String.valueOf(iteratingArrayUsingFor[index]));
            index++;
        }


        index = 0; // set flag to 0 for clarification
        log.info(("------------------"));
        log.info(("using do while loop"));
        do{
            log.info(String.valueOf(iteratingArrayUsingFor[index]));
            index++;
        }while (index<len);
    }
}
