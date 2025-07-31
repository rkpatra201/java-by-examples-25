package com.example.app;

// find 1st non-repeated character from the string
public class App1 {
    public static void main(String[] args) {

        String s = "abcabcd";
        int len = s.length();
        int i;
        for ( i = 0 ; i<len ; i++){
            boolean unique = true ;
            for (int j =0 ; j<len ; j++){
                if (i!=j && s.charAt(i) == s.charAt(j)){
                    unique = false;
                    break;
                }
            }
            if (unique){
                System.out.println("1st non repleated char "+ s.charAt(i));
                break;
            }
        }
    }
}
