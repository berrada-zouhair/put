package com.put.chapter4.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FootballTeamTest {

  private final int ANY_WINS_NUMBER = 10;

  @ParameterizedTest
  @ValueSource(ints = {0, 10, 2, 50})
  void constructor_should_init_number_of_wins(int wins) {
    FootballTeam team = new FootballTeam(wins);
    assertThat(team.getWins())
        .as("Number of wins")
        .isEqualTo(wins);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -20, -5})
  void constructor_should_throw_exception_when_wins_are_negative(int wins) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new FootballTeam(wins))
        .withMessage("wins must be positive")
        .withNoCause();
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -20, -5})
  void constructor_should_throw_exception_when_wins_value_is_negative(int wins) {
    Throwable throwable = catchThrowable(() -> new FootballTeam(wins));
    assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("wins must be positive")
        .hasNoCause();
  }

  @Test
  void football_team_class_should_implement_comparable() {
    assertThat(new FootballTeam(ANY_WINS_NUMBER)).isInstanceOf(Comparable.class);
  }

  @ParameterizedTest
  @CsvSource({"5, 3", "10, 2", "1, 0"})
  void teams_with_more_won_matches_should_be_greater(int wins1, int wins2) {
    FootballTeam footballTeam1 = new FootballTeam(wins1);
    FootballTeam footballTeam2 = new FootballTeam(wins2);
    int comparison = footballTeam1.compareTo(footballTeam2);
    assertThat(comparison).isGreaterThan(0);
  }

  @ParameterizedTest
  @CsvSource({"5, 5", "10, 10", "1, 1"})
  void teams_with_same_won_matches_should_be_equal(int wins1, int wins2) {
    FootballTeam footballTeam1 = new FootballTeam(wins1);
    FootballTeam footballTeam2 = new FootballTeam(wins2);
    int comparison = footballTeam1.compareTo(footballTeam2);
    assertThat(comparison).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource({"4, 5", "1, 10", "0, 1"})
  void teams_with_same_won_matches_should_be_lower(int wins1, int wins2) {
    FootballTeam footballTeam1 = new FootballTeam(wins1);
    FootballTeam footballTeam2 = new FootballTeam(wins2);
    int comparison = footballTeam1.compareTo(footballTeam2);
    assertThat(comparison).isLessThan(0);
  }
}
