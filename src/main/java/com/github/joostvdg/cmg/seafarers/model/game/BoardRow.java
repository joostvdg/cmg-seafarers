package com.github.joostvdg.cmg.seafarers.model.game;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class BoardRow {
  private final Integer rowId;
  private final int numberOfTiles;

  public Integer getRowId() {
    return rowId;
  }

  public int getNumberOfTiles() {
    return numberOfTiles;
  }

  public BoardRow(Integer rowId, int numberOfTiles) {
    this.rowId = rowId;
    this.numberOfTiles = numberOfTiles;
  }
}
