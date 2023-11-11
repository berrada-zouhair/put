package com.put.chapter8.random;

import static com.put.chapter8.random.UserToPersonConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

import com.github.javafaker.Faker;
import java.util.stream.Stream;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserToPersonConverterTest {

  @Test
  void should_convert_user_names_to_person_nick() {
    String name = RandomStringUtils.randomAlphabetic(8);
    String surname = RandomStringUtils.randomAlphabetic(12);
    User user = new User(name, surname);
    Person person = convert(user);
    assertThat(person.getNick()).isEqualTo(name + " " + surname);
  }

  @ParameterizedTest
  @MethodSource("generateUsersNamesAndSurname")
  void should_convert_users_to_people(String name, String surname) {
    assertThat(convert(new User(name, surname)).getNick()).isEqualTo(name + " " + surname);
  }

  private static Stream<Arguments> generateUsersNamesAndSurname() {
    Faker faker = new Faker();
    return Stream.generate(
        () -> of(faker.name().firstName(), faker.name().lastName()))
        .limit(10);
  }
}
