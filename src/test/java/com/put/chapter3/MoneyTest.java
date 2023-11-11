package com.put.chapter3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

  private String VALID_CURRENCY = "USD";

  @Test
  void constructor_should_set_amount_and_currency() {
    Money money = new Money(VALID_CURRENCY, 10);
    assertThat(money.getCurrency()).isEqualTo(VALID_CURRENCY);
    assertThat(money.getAmount()).isEqualTo(10);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 20, 30})
  void constructor_should_set_amount_and_currency_2(int amount) {
    Money money = new Money(VALID_CURRENCY, amount);
    assertThat(money.getCurrency()).isEqualTo(VALID_CURRENCY);
    assertThat(money.getAmount()).isEqualTo(amount);
  }

  @ParameterizedTest(name = "{index} => currency {0} with amount {1}")
  @CsvSource({"USD, 10", "EUR, 20", "MAD, 30"})
  void constructor_should_set_amount_and_currency_3(String currency, int amount) {
    Money money = new Money(currency, amount);
    assertThat(money.getCurrency()).isEqualTo(currency);
    assertThat(money.getAmount()).isEqualTo(amount);
  }

  @ParameterizedTest
  @CsvSource({", 10", "'', 20"})
  void should_get_Currency_as_null_then_as_emty(String currency, int amount) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(currency, amount));
  }

  @Test
  void constructor_should_throw_exception_when_invalid_amount() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(VALID_CURRENCY, -1));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -200, -300})
  void constructor_should_throw_exception_when_invalid_amount_2(int invalidAmount) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(VALID_CURRENCY, invalidAmount));
  }

  @ParameterizedTest
  @MethodSource("invalidCurrencies")
  void constructor_should_throw_exception_when_invalid_currency(String invalidCurrency) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(invalidCurrency, 10));
  }

  @ParameterizedTest
  @MethodSource("invalidMoneyEntries")
  void constructor_should_throw_exception_when_invalid_entry(String invalidCurrency, int invalidAmount) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(invalidCurrency, invalidAmount));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data_source.csv", numLinesToSkip = 1)
  void should_read_data_from_csv_file(int value1, int value2) {
    System.out.println(value1 + ", " + value2);
  }

  @ParameterizedTest
  @NullAndEmptySource
  void constructor_should_throw_exception_when_cuuerncy_is_null_or_empty(String invalidCurrency) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Money(invalidCurrency, 10));
  }

  private static Stream<String> invalidCurrencies() {
    return Stream.of(null, "", " ", "\t", "\r");
  }

  private static Stream<Arguments> invalidMoneyEntries() {
    return Stream.of(
        Arguments.of(null, -1),
        Arguments.of("", -20),
        Arguments.of(" ", -3)
    );
  }
}
