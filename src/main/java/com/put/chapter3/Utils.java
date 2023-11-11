package com.put.chapter3;

import static java.util.Objects.isNull;

public class Utils {

  private Utils() {
  }

  public static String reverse(String aString) {
    if (isNull(aString)) {
      throw new IllegalArgumentException();
    }
    String result = "";
    for (int i = aString.length()-1; i >= 0 ; i--) {
      result = result.concat(String.valueOf(aString.charAt(i)));
    }
    return result;
  }
}
