package com.put.chapter6.custom.assertions;

public class Book {

  private String title;
  private String language;
  private int pages;

  public Book(String title, String language, int pages) {
    this.title = title;
    this.language = language;
    this.pages = pages;
  }

  public String getTitle() {
    return title;
  }

  public String getLanguage() {
    return language;
  }

  public int getPages() {
    return pages;
  }
}
