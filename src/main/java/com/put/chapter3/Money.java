package com.put.chapter3;

public class Money {

  private final String currency;
  private final int amount;

  public Money(String currency, int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    if (currency == null || currency.trim().isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.currency = currency;
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public int getAmount() {
    return amount;
  }
}
