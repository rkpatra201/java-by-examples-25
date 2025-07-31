package com.example.app;

import java.lang.reflect.Modifier;

public class App3 {
    public static void main(String[] args) {
      UtkalUniversity university = new UtkalUniversity();
      Class institute = UtkalUniversity.class;
      int modifier = institute.getModifiers();
      System.out.println(Modifier.toString(modifier));
    }
}
class Institute{
    public void university(){
        System.out.println("UGC");
    }
}
