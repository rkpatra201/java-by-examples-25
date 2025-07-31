package com.example.models;

public class Calculator {
  // static member
  // non-static member (use this while accessing non-static members inside the class)
  private static int x = 10; // only one time memory allocation
  private static int z = 10; // only one time memory allocation
  private int y = 20; // for every object memory allocation

  // static method: object not required to access it
  // access using class name
  public static int sum(int input){
    return input + x + z;
  }

  // if your logic depends on current object state then it must be non-static
  public int sumInstanceMethod(int input){
    // this keyword always use with non-static member
    return input + x + z + this.y;
  }

  // start = 10, end = 50
  public int evenSum(int start, int end){
    int sum = 0;
    for(int i = start; i <= end; i++){
      if(i % 2 == 0){
        sum += i;
      }
    }
    return sum;
  }

  public static int oddSum(int start, int end){
    int sum = 0;
    for(int i = start; i <= end; i++){
      if(i % 2 == 1){
        sum += i;
      }
    }
    return sum;
  }
}

/**
 * static:
 * 64 bit allocate
 *
 * non-static
 * 20 objects
 * 32 bit * 20 = 640 bit + (static memory)
 */
