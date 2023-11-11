package com.put.chapter4.tdd;

public class FootballTeam implements Comparable<FootballTeam> {

  private int wins;

  public FootballTeam(int wins) {
    if (wins < 0) {
      throw new IllegalArgumentException("wins must be positive");
    }
    this.wins = wins;
  }

  public int getWins() {
    return wins;
  }

  @Override
  public int compareTo(FootballTeam o) {
    return this.wins - o.wins;
  }
}
