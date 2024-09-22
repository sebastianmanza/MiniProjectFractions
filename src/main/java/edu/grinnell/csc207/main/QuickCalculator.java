package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;

public class QuickCalculator {
   public static void main(String[] args) {
   PrintWriter pen = new PrintWriter(System.out, true);
   if (args.length < 1) {
     System.err.println("Incorrect number of parameters");
     return;
   } // if there are no args
   //making a second version of BFCalculator so it wont interfere with Interactive
   BFCalculator calc2 = new BFCalculator();
   BFRegisterSet register2 = new BFRegisterSet();
   BigFraction storedVal = calc2.get();
   Scanner input = new Scanner(args[0]);
   String currentInput = input.nextLine();
   String[] segmentOne = currentInput.split(" ");
   //creating BigFraction from strings
   BigFraction x = new BigFraction(segmentOne[0]);
   BigFraction y = new BigFraction(segmentOne[2]);
   //looking at args[2]
   Scanner inputTwo = new Scanner(args[1]);
   String secondInput = inputTwo.nextLine();
   String[] segmentTwo = secondInput.split(" ");
   //looking at args[3]
   Scanner inputThree = new Scanner(args[2]);
   String thirdInput = inputThree.nextLine();
   String[] segmentThree = thirdInput.split(" ");
   BigFraction z = new BigFraction(segmentThree[2]);
   //initializes the index the register is set to be stored
   char register = segmentTwo[1].charAt(0);
   register2.store(register, storedVal);
   //does calculation on fractions
   if (! (segmentOne[1].equals("+")) || segmentOne[1].equals("-") || segmentOne[1].equals("/") || segmentOne[1].equals("*")) {
     System.err.println("Incorrect input: operations +, -, /, or * must be inputted");
   } // checks the operator
   else if (segmentOne[1].equals("+")) {
     storedVal = x.add(y);
     storedVal = storedVal.simplify(storedVal);
     pen.println( segmentOne[0] + " + " + segmentOne[2] + " = " + storedVal.toString());
   } // else if it is subtract
   else if (segmentOne[1].equals("-")) {
     storedVal = x.subtract(y);
     storedVal = storedVal.simplify(storedVal);
     pen.println(segmentOne[0] + " - " + segmentOne[2] + " = " + storedVal.toString());
   } // else if it was divide
   else if (segmentOne[1].equals("/")) {
     storedVal = x.divide(y);
     storedVal = storedVal.simplify(storedVal);
     pen.println(segmentOne[0] + " / " + segmentOne[2] + " = " + storedVal.toString());
     pen.flush();
   } // else if
   else if (segmentOne[1].equals("*")) {
     storedVal = x.multiply(y);
     storedVal = storedVal.simplify(storedVal);
     pen.println(segmentOne[0] + " * " + segmentOne[2] + " = " + storedVal.toString());
   } // else if
   //Stores the BigFraction within the register
   char reg = segmentTwo[1].charAt(0);
   register2.store(reg, storedVal);
   
   //does the calculation for args[3]
   if (segmentThree[1].equals("+")) {
     storedVal = storedVal.add(z);
     storedVal = storedVal.simplify(storedVal);
     pen.println(register + " + " + segmentThree[2] + " = " + storedVal.toString());
   } // if 
   else if (segmentThree[1].equals("-")) {
     storedVal = storedVal.subtract(z);
     storedVal = storedVal.simplify(storedVal);
     pen.println(register + " - " + segmentThree[2] + " = " + storedVal.toString());
   } // if it equals subtract
   else if (segmentThree[1].equals("/")) {
     storedVal = storedVal.divide(z);
     storedVal = storedVal.simplify(storedVal);
     pen.println(register + " / " + segmentThree[2] + " = " + storedVal.toString());
   } // if it equals divide
   else if (segmentThree[1].equals("*")) {
     storedVal = storedVal.multiply(z);
     storedVal = storedVal.simplify(storedVal);
     pen.println(register + " * " + segmentThree[2] + " = " + storedVal.toString());
   } // if it equals multiply

   // closing the scanners
   input.close();
   inputTwo.close();
   inputThree.close();
 } //main
} //QuickCalculator

