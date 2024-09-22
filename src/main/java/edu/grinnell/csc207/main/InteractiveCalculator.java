package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BigFraction;

import edu.grinnell.csc207.util.BFCalculator;

import edu.grinnell.csc207.util.BFRegisterSet;

import java.io.PrintWriter;

import java.util.Scanner;

public class InteractiveCalculator {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calc = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    String currentInput;
    BigFraction storedVal = calc.get();
    int i = 0;
    while (!args[i].equals("QUIT")) {
      pen.printf(">");
      pen.flush();
      currentInput = input.nextLine();
      String[] currentInputs = currentInput.split(" ");
      BigFraction one = new BigFraction(currentInputs[0]);
      BigFraction two = new BigFraction(currentInputs[2]);
      if (currentInputs[0].equals("STORE")){
        char whichReg = currentInputs[1].charAt(0);
        register.store(whichReg, storedVal);
      }
      else if (java.lang.Character.isAlphabetic(currentInputs[0].charAt(0))){
        one = register.get(currentInputs[0].charAt(0));
      }
      else if (java.lang.Character.isAlphabetic(currentInputs[2].charAt(0))){
        two = register.get(currentInputs[2].charAt(0));
      else {
        String operator = currentInputs[1];
        if (operator.equals("+")){
          storedVal = one.add(two);
        }
        else if (operator.equals("-")){
          storedVal = one.subtract(two);
        }
        else if (operator.equals("*")){
          storedVal = one.multiply(two);
        }
        else if (operator.equals("/")){
          storedVal = one.divide(two);
        }
      storedVal = storedVal.simplify(storedVal);
      pen.println(storedVal.toString());
      }
    }
    input.close();
  }


}
