package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFCalculator {
  /** A numerator of 0, the default. */
  private static final BigInteger DEFAULT_NUM = BigInteger.valueOf(0);

  /** A default BigFraction valued at 0. */
  private static final BigFraction DEFAULT_FRAC =
      new BigFraction(DEFAULT_NUM, BigInteger.valueOf(1));

  /** The current stored total. */
  BigFraction stored = DEFAULT_FRAC;

  /**
   * Gets the last computed value (returns 0 if no value).
   * 
   * @return the stored value
   */
  public BigFraction get() {
    return stored;
  }

  /**
   * Adds val to the stored BigFraction
   * 
   * @param val the added BigFraction
   */
  public void add(BigFraction val) {
    stored = stored.add(val);
  }

  /**
   * Subtracts val from the stored BigFraction.
   * 
   * @param val the BigFraction to subtract
   */
  public void subtract(BigFraction val) {
    stored = stored.subtract(val);
  }

  /**
   * Multiplies the stored BigFraction by val
   * 
   * @param val A BigFraction to multiply
   */
  public void multiply(BigFraction val) {
    stored = stored.multiply(val);
  }

  /**
   * Divides the stored BigFraction by val.
   * 
   * @param val A BigFraction to divide by
   */
  public void divide(BigFraction val) {
    stored = stored.divide(val);
  }

  /** Resets the last computed value to the default (0) */
  public void clear() {
    stored = DEFAULT_FRAC;
  }


} // BFCalculator()
