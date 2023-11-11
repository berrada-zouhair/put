package com.put.chapter7.time;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloTest {

  private TimeProvider timeProvider;
  private Hello hello;

  private final String MORNING_MESSAGE = "Good morning !";
  private final String AFTERNOON_MESSAGE = "Good after noon !";

  @BeforeEach
  void setUp() {
    timeProvider = mock(TimeProvider.class);
    hello = new Hello(timeProvider);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
  void should_say_good_morning(int morningHour) {
    when(timeProvider.getDayHour()).thenReturn(morningHour);
    String message = hello.sayHello();
    Assertions.assertThat(message).isEqualTo(MORNING_MESSAGE);
  }

  @ParameterizedTest
  @ValueSource(ints = {12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23})
  void should_say_good_afternoon(int afternoonHour) {
    when(timeProvider.getDayHour()).thenReturn(afternoonHour);
    String message = hello.sayHello();
    Assertions.assertThat(message).isEqualTo(AFTERNOON_MESSAGE);
  }
}
