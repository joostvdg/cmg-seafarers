package com.github.joostvdg.cmg.seafarers.model.pieces;

public enum Resource {
  ANY(0, "Any"), // harbor = 1:3, for tiles "Gold"
  LUMBER(1, "Lumber"),
  WOOL(2, "Wool"),
  GRAIN(3, "Grain"),
  BRICK(4, "Brick"),
  ORE(5, "Ore"),
  DESERT(6, "Desert"),
  SEA(7, "Sea");

  private final int code;
  private final String displayName;

  private Resource(int code, String displayName) {
    this.code = code;
    this.displayName = displayName;
  }
}
