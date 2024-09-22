package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A simple implementation of arbitrary-precision Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Sebastian Manza and Yash Malik
 * 
 */
public class BigFraction {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /** The default numerator when creating fractions. */
  private static final BigInteger DEFAULT_NUMERATOR = BigInteger.valueOf(0);

  /** The default denominator when creating fractions. */
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(1);

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * @param numerator The numerator of the fraction.
   * 
   * @param denominator The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)


  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * @param numerator The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   * 
   */

  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
  } // BigFraction(int, int)

  /**
   * A new fraction created from parsing a string
   * 
   * @param str the input string
   */

  public BigFraction(String str) {
    if (str.contains("/")) {
      String[] nums = str.split("/");
      int numer = Integer.valueOf(nums[0]) - 48;
      int denom = Integer.valueOf(nums[2]) - 48;
      this.num = BigInteger.valueOf(numer);
      this.denom = BigInteger.valueOf(denom);
    }
    else {
      int numer = Integer.valueOf(str) - 48;
      this.num = BigInteger.valueOf(numer);
      this.denom = BigInteger.valueOf(1);
    }
  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * 
   * Express this fraction as a double.
   * 
   * @return the fraction approximated as a double.
   */

  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()


  /**
   * 
   * Add another faction to this fraction.
   * 
   * @param addend The fraction to add.
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(addend.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Subtracts another fraction from this fraction.
   * 
   * @param subtractend The fraction to subtract.
   * @return the result of the subtraction.
   */
  public BigFraction subtract(BigFraction subtractend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(subtractend.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(subtractend.denom)).subtract(subtractend.num.multiply(this.denom));
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Simplifies a fraction to it's simplest form
   * @param tooComplex A fraction that is too complex
   * @return a new simplified BigFraction
   */
  public BigFraction simplify(BigFraction tooComplex){
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    BigInteger gcd = this.num.gcd(this.denom);
    resultNumerator = this.num.divide(gcd);
    resultDenominator = this.denom.divide(gcd);
    return new BigFraction(resultNumerator, resultDenominator);
  }

  /**
   * Get the denominator of this fraction.
   * 
   * @return the denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   * 
   * @return the numerator
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   * 
   * @return a string that represents the fraction.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
    else if (this.denom.equals(BigInteger.ONE)) {
      return this.num.toString();
    }
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  /**
   * Multiplies two BigFractions
   * 
   * @param needsMult the BigFraction to multiply by
   * @return a multiplied big fraction
   */
  public BigFraction multiply(BigFraction needsMult) {
    this.num = this.num.multiply(needsMult.num);
    this.denom = this.denom.multiply(needsMult.denom);
    return new BigFraction(this.num, this.denom);
  }

  /**
   * Divides BigFraction one by BigFraction two
   * 
   * @param one The first BigFraction
   * @param two the fraction one is being divided by
   * @return A new BigFraction
   */
  public BigFraction divide(BigFraction divisor) {
    this.num = this.num.multiply(divisor.denom);
    this.denom = this.denom.multiply(divisor.num);
    return new BigFraction(this.num, this.denom);
  }


  public static BigFraction fractional(BigFraction one) {
    BigFraction result = new BigFraction(one.num.mod(one.denom), one.denom);
    return result;
  }
} // class BigFraction
