package com.github.joostvdg.cmg.seafarers.model.pieces;

public class Tile {

  private final Landscape landscape;

  private final Harbor harbor;

  private final TileNumber number;

  public Tile(Landscape landscape, Harbor harbor, TileNumber number) {
    this.harbor = harbor;
    this.landscape = landscape;
    this.number = number;
  }

  @Override
  public String toString() {
    return "|Tile{" + "landscape=" + landscape + ", harbor=" + harbor + ", number=" + number + "}|";
  }
}
