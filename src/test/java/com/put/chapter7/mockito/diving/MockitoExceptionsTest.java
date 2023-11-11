package com.put.chapter7.mockito.diving;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoExceptionsTest {

  @Disabled
  @Test(/*expected = RuntimeException.class*/)
  void should_throw_exception() {
    Car car = Mockito.mock(Car.class);
    when(car.needsFuel()).thenThrow(RuntimeException.class);
  }

  @Test
  void accelerate_method_should_throw_exception() {
    Car car = mock(Car.class);
    doThrow(new IllegalArgumentException()).when(car).accelerate();
    Throwable thrown = Assertions.catchThrowable(car::accelerate);
    Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }
}
