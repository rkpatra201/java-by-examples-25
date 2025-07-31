package com.example.models;

public class Sidecar {

  private String memoryLimit;
  private String cpuLimit;

  public Sidecar(){
    this("200GB");
    System.out.println("the default constructor");
  }

  public Sidecar(String memoryLimit){
    this(memoryLimit, "4CORE");
    this.memoryLimit = memoryLimit;
    System.out.println("the 1 param constructor");
  }

  public Sidecar(String memoryLimit, String cpuLimit){
    System.out.println("the 2 param constructor");
    this.memoryLimit = memoryLimit;
    this.cpuLimit = cpuLimit;
  }

  @Override
  public String toString() {
    return "{" +
        "memoryLimit="+this.memoryLimit +
        ",cpuLimit="+this.cpuLimit +
        "}";
  }
}
