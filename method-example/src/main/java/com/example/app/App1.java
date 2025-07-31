package com.example.app;

public class App1 {
  public static void main(String[] args) {
    String name1 = "john";

    int count = 0;
    for (int i = 0; i < name1.length(); i++) {
      char ch = name1.charAt(i);
      if (ch == 'a'
          || ch == 'e'
          || ch == 'i'
          || ch == 'o'
          || ch == 'u') {
        count = count + 1;
      }
    }

    System.out.println(count);

    String name2 = "alisha";

    count = 0;
    for (int i = 0; i < name2.length(); i++) {
      char ch = name2.charAt(i);
      if (ch == 'a'
          || ch == 'e'
          || ch == 'i'
          || ch == 'o'
          || ch == 'u') {
        count = count + 1;
      }
    }
    System.out.println(count);
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

    System.out.println(count);

    return count;

  }
}
