package com.put.chapter3;

import static com.put.chapter3.Utils.reverse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtilsTest {

  @ParameterizedTest
  @CsvSource({"zouhair, riahuoz", "zakaria, airakaz", "driss, ssird"})
  void should_reverse_string(String string, String reversedString) {
    assertThat(reverse(string)).isEqualTo(reversedString);
  }

  @Test
  void reverse_string_should_throw_exception_when_string_is_null() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> reverse(null));
  }

  @Test
  void reverse_string_should_get_empty_string_when_string_is_empty() {
    assertThat(reverse("")).isEqualTo("");
  }
}
