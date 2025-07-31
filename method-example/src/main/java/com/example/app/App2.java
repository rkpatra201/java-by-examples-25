package com.example.app;

public class App2 {
  public static void main(String[] args) {
    String name1 = "john";
    String name2 = "alisha";
    System.out.println(countVowels(name1));
    System.out.println(countVowels(name2));
  }

  public static int countVowels(String input) {
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == 'a'
          || ch == 'e'
          || ch == 'i'
          || ch == 'o'
          || ch == 'u') {
        count = count + 1;
      }
    }

  //  System.out.println(count);

    return count;

  }
}
