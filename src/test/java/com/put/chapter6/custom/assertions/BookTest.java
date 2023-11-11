package com.put.chapter6.custom.assertions;

import static com.put.chapter6.custom.assertions.MyProjectAssertions.assertThat;
import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.anyOf;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class BookTest {

  private Condition<Book> writtenInEnglish = new Condition<>(
      book -> book.getLanguage().equalsIgnoreCase("English"),
      "English book");

  private Condition<Book> writtenInArabic = new Condition<>(
      book -> book.getLanguage().equalsIgnoreCase("Arabic"),
      "Arabic book");

  private Condition<Book> moreThanOneHundredPages = new Condition<>(book -> book.getPages() > 100,
      "More than 100 pages book");

  private Condition<Book> lessThanOneHundredPages = new Condition<>(book -> book.getPages() < 100,
      "Less than 100 pages book");

  @Test
  void constructor_should_set_title() {
    String bookTitle = "book title";
    Book book = new Book(bookTitle, "English", 200);
    assertThat(book)
        .hasTitle(bookTitle)
        .is(writtenInEnglish)
        .has(moreThanOneHundredPages)
        .is(anyOf(writtenInArabic, writtenInEnglish))
        .isNot(writtenInArabic)
        .doesNotHave(lessThanOneHundredPages)
        .is(allOf(writtenInEnglish, moreThanOneHundredPages));
  }
}
