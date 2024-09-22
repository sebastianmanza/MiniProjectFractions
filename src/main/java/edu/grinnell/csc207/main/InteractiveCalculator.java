package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BigFraction;

import edu.grinnell.csc207.util.BFCalculator;

import edu.grinnell.csc207.util.BFRegisterSet;

import java.lang.String;

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
    pen.printf(">");
    pen.flush();
    currentInput = input.nextLine();
    String[] currentInputs = currentInput.split(" ");
    BigFraction one = new BigFraction(currentInputs[0]);
    BigFraction two = new BigFraction(currentInputs[2]);
    while (!currentInputs[i].equals("QUIT")) {
      if (currentInputs[0].equals("STORE")) {
        char whichReg = currentInputs[1].charAt(0);
        register.store(whichReg, storedVal);
      }
      if (java.lang.Character.isAlphabetic(currentInputs[0].charAt(0))) {
        one = register.get(currentInputs[0].charAt(0));
      }
      if (java.lang.Character.isAlphabetic(currentInputs[2].charAt(0))) {
        two = register.get(currentInputs[2].charAt(0));
      } else {
        String operator = currentInputs[1];
        if (operator.equals("+")) {
          storedVal = one.add(two);
        } else if (operator.equals("-")) {
          storedVal = one.subtract(two);
        } else if (operator.equals("*")) {
          storedVal = one.multiply(two);
        } else if (operator.equals("/")) {
          storedVal = one.divide(two);
        }
        storedVal = storedVal.simplify(storedVal);
        pen.println(storedVal.toString());
        pen.println("one" + one.toString());
        pen.println("two" + two.toString());

        pen.printf(">");
        pen.flush();
        currentInput = input.nextLine();
        currentInputs = currentInput.split(" ");
      }
    }
    input.close();
  }
}
