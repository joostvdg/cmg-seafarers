package com.github.joostvdg.cmg.seafarers.model.pieces;

public enum TileNumber {
  TWO(2, 27), // z
  THREE(3, 55), // y
  FOUR(4, 83), // x
  FIVE(5, 111), // w
  SIX(6, 139), // v
  EIGHT(8, 139), // u
  NINE(9, 111), // t
  TEN(10, 83), // s
  ELEVEN(11, 55), // r
  TWELVE(12, 27); // q
  // p - meaning, no tile

  private final int value;
  private final int probabilityScore;

  private TileNumber(int value, int probabilityScore) {
    this.value = value;
    this.probabilityScore = probabilityScore;
  }
}
