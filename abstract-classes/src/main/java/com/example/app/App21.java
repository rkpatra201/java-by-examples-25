package com.example.app;

// keep common logic in parent class. child class overridden the abstract methods
public class App21 {
  public static void main(String[] args) {
    Calculator square = new SquareCalculator("2");
    square.printResult();

    Calculator cube = new CubeCalculator("3");
    cube.printResult();
  }

  // given a string input, calculate its square
  private static abstract class Calculator{
    private String input;

    public Calculator(String input) {
      this.input = input;
    }

    protected abstract void calculate();

    protected void validate(){
      Integer.parseInt(this.input);
    }

    protected void printResult(){
      this.validate();
      this.calculate();
    }

    protected int getAsNum(){
      return Integer.parseInt(this.input);
    }
  }

  private static class SquareCalculator extends Calculator{

    public SquareCalculator(String input) {
      super(input);
    }

    @Override
    protected void calculate() {
      int in = getAsNum();
      System.out.println(Math.pow(in, 2));
    }
  }


  private static class CubeCalculator extends Calculator{

    public CubeCalculator(String input) {
      super(input);
    }

    @Override
    protected void calculate() {
      int in = getAsNum();
      System.out.println(Math.pow(in, 3));
    }
  }
}
