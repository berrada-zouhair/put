package com.put.chapter7.time;

public class Hello {

  private TimeProvider timeProvider;

  public Hello(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String sayHello() {
    boolean isMorning = timeProvider.getDayHour() < 12;
    if (isMorning) {
      return "Good morning !";
    }
    return "Good after noon !";
  }
}
