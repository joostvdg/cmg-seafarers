package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Harbor;
import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.*;

@RegisterForReflection
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

  protected abstract List<BoardRow> boardRows();

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
      tilesAreShuffled = true;
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

  protected static List<Tile> inflateTilesForRow(String code, int codeIndex, BoardRow row) {
    List<Tile> tiles = new ArrayList<>();

    for (int i = 0; i < row.getNumberOfTiles(); i++) {
      String characterForLandscape = code.substring(codeIndex, codeIndex + 1);
      codeIndex++;
      String characterForNumber = code.substring(codeIndex, codeIndex + 1);
      codeIndex++;

      Landscape landscape = Board.LANDSCAPE_STRING_MAP_REVERSE.get(characterForLandscape);
      TileNumber tileNumber = Board.TILE_NUMBER_STRING_MAP_REVERSE.get(characterForNumber);
      Tile tile = new Tile(landscape, Harbor.NONE, tileNumber);
      tiles.add(tile);
    }
    return tiles;
  }

  protected Map<Integer, List<Tile>> layBoardTiles() {
    Map<Integer, List<Tile>> boardTiles = new TreeMap<>();
    for (int i = 0; i < boardRows().size(); i++) {
      BoardRow row = boardRows().get(i);
      boardTiles.put(i, createColumnTiles(row.getNumberOfTiles()));
    }
    return boardTiles;
  }
}
