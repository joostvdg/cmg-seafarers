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

  public Landscape getLandscape() {
    return landscape;
  }

  public Harbor getHarbor() {
    return harbor;
  }

  public TileNumber getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "[" + landscape + ", " + number + "]";
  }

  public boolean hasNumber() {
    return number != null;
  }
}
