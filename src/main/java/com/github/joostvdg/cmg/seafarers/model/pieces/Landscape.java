package com.github.joostvdg.cmg.seafarers.model.pieces;

public enum Landscape {
  GOLD("Gold", Resource.GOLD), // a
  DESERT("Desert", Resource.DESERT), // b
  FIELD("Field", Resource.GRAIN), // c
  FOREST("Forest", Resource.LUMBER), // d
  PASTURE("Pasture", Resource.WOOL), // e
  MOUNTAINS("Mountains", Resource.ORE), // f
  HILLS("Hills", Resource.BRICK), // g
  SEA("Sea", Resource.SEA); // h

  private final String displayName;
  private final Resource resource;

  private Landscape(String displayName, Resource resource) {
    this.displayName = displayName;
    this.resource = resource;
  }

  public String getDisplayName() {
    return displayName;
  }

  @Override
  public String toString() {
    return getDisplayName();
  }
}
