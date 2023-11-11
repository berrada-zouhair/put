package com.put.chapter6.custom.assertions;

import org.assertj.core.api.Assertions;

public class MyProjectAssertions extends Assertions {

  public static BookAssert assertThat(Book actual) {
    return new BookAssert(actual);
  }

}
