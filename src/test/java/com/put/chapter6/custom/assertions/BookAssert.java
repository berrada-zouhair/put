package com.put.chapter6.custom.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BookAssert extends AbstractAssert<BookAssert, Book> {

  public BookAssert(Book actual) {
    super(actual, BookAssert.class);
  }

  public static BookAssert assertThat(Book actual) {
    return new BookAssert(actual);
  }

  public BookAssert hasTitle(String title) {
    isNotNull();
    Assertions.assertThat(actual.getTitle()).as("Title").isEqualTo(title);
    return this;
  }

}
