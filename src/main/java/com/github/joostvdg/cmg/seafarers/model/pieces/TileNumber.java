package com.github.joostvdg.cmg.seafarers.model.pieces;

public enum TileNumber {
  TWO(2, 27),
  THREE(3, 55),
  FOUR(4, 83),
  FIVE(5, 111),
  SIX(6, 139),
  EIGHT(8, 139),
  NINE(9, 111),
  TEN(10, 83),
  ELEVEN(11, 55),
  TWELVE(12, 27);

  private final int value;
  private final int probabilityScore;

  private TileNumber(int value, int probabilityScore) {
    this.value = value;
    this.probabilityScore = probabilityScore;
  }
}
