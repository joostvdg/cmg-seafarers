package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Harbor;
import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGame {

  private final List<Tile> tiles;
  private final List<TileNumber> numbers;

  private int numbersCounter = 0;
  private int tilesCounter = 0;
  private boolean tilesAreShuffled = false;
  private boolean numbersAreShuffled = false;

  public AbstractGame() {
    tiles = new LinkedList<>();
    numbers = new LinkedList<>();
  }

  protected abstract void initNumbers();

  protected abstract void initTiles();

  protected List<Tile> tiles() {
    return this.tiles;
  }

  protected void addNumbersOfType(int numberOfNumbers, TileNumber tileNumber) {
    for (int i = 0; i < numberOfNumbers; i++) {
      numbers.add(tileNumber);
    }
  }

  protected Tile retrieveRandomTile() {
    if (!tilesAreShuffled) {
      Collections.shuffle(tiles);
    }
    Tile tile = tiles.get(tilesCounter);
    tilesCounter++;
    return tile;
  }

  protected TileNumber retrieveRandomTileNumber() {
    if (!numbersAreShuffled) {
      Collections.shuffle(numbers);
    }
    TileNumber tileNumber = numbers.get(numbersCounter);
    numbersCounter++;
    return tileNumber;
  }

  protected List<Tile> createColumnTiles(int numberOfTiles) {
    List<Tile> tilesOfColumn = new LinkedList<>();
    for (int i = 0; i < numberOfTiles; i++) {
      tilesOfColumn.add(i, retrieveRandomTile());
    }
    return tilesOfColumn;
  }

  protected void addTilesOfType(int numberOfTiles, Landscape landscapeType) {
    for (int i = 0; i < numberOfTiles; i++) {
      TileNumber tileNumber = null;
      if (landscapeType != Landscape.DESERT && landscapeType != Landscape.SEA) {
        tileNumber = retrieveRandomTileNumber();
      }
      Tile tile = new Tile(landscapeType, Harbor.NONE, tileNumber);
      tiles().add(tile);
    }
  }
}
