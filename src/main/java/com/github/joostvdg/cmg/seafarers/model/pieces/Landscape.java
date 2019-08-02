package com.github.joostvdg.cmg.seafarers.model.pieces;

public enum Landscape {
  GOLD("Gold", Resource.ANY),
  DESERT("Desert", Resource.DESERT),
  FIELD("Field", Resource.GRAIN),
  FOREST("Forest", Resource.LUMBER),
  PASTURE("Pasture", Resource.WOOL),
  MOUNTAINS("Mountains", Resource.ORE),
  HILLS("Hills", Resource.BRICK),
  SEA("Sea", Resource.SEA);

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
