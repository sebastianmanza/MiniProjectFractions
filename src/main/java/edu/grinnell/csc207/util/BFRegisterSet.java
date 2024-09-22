package edu.grinnell.csc207.util;

public class BFRegisterSet {

  BigFraction[] reglist = new BigFraction[26];

  /** Stores the given value in the specified register.
   * 
   * @param register The register
   * @param val The stored value
  */
  public void store(char register, BigFraction val){
    reglist[register - (int) 'a'] = val;
  }
  
  public BigFraction get(char register){
    return reglist[register - (int) 'a'];

  }
}
