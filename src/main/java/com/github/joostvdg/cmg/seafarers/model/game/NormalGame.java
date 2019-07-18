package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Harbor;
import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import java.util.*;

/**
 * NormalGame, a game for up to four players. For inspiration for the maps:
 * http://gemkapocs.keszthelyonline.hu/letoltes/Complete_Scenario_and_Variant_Guide.pdf
 */
public class NormalGame implements Game {

  private final List<Tile> tiles;
  private final List<TileNumber> numbers;
  private final Board board;
  private static final int TOTAL_COLUMNS = 11;

  private int numbersCounter = 0;
  private int tilesCounter = 0;
  private boolean tilesAreShuffled = false;
  private boolean numbersAreShuffled = false;

  public NormalGame() {
    tiles = new LinkedList<>();
    numbers = new LinkedList<>();
    initNumbers();
    initTiles();
    this.board = createBoard();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, List<Tile>> entry : board.getBoard().entrySet()) {
      stringBuilder.append("-------------------\n");
      stringBuilder.append("Row " + entry.getKey() + "\n");
      entry.getValue().forEach(stringBuilder::append);
      stringBuilder.append("\n-------------------");
    }
    return stringBuilder.toString();
  }

  private Board createBoard() {
    Map<String, List<Tile>> boardTiles = layBoardTiles();
    return new Board(boardTiles);
  }

  private Map<String, List<Tile>> layBoardTiles() {
    Map<String, List<Tile>> boardTiles = new TreeMap<>();
    boardTiles.put("0", createColumnTiles(1));
    boardTiles.put("1", createColumnTiles(2));
    boardTiles.put("2", createColumnTiles(3));
    boardTiles.put("3", createColumnTiles(4));
    boardTiles.put("4", createColumnTiles(4));
    boardTiles.put("5", createColumnTiles(4));
    boardTiles.put("6", createColumnTiles(4));
    boardTiles.put("7", createColumnTiles(4));
    boardTiles.put("8", createColumnTiles(3));
    boardTiles.put("9", createColumnTiles(2));
    boardTiles.put("10", createColumnTiles(1));
    return boardTiles;
  }

  private Tile retrieveRandomTile() {
    if (!tilesAreShuffled) {
      Collections.shuffle(tiles);
    }
    Tile tile = tiles.get(tilesCounter);
    tilesCounter++;
    return tile;
  }

  private TileNumber retrieveRandomTileNumber() {
    if (!numbersAreShuffled) {
      Collections.shuffle(numbers);
    }
    TileNumber tileNumber = numbers.get(numbersCounter);
    numbersCounter++;
    return tileNumber;
  }

  private List<Tile> createColumnTiles(int numberOfTiles) {
    List<Tile> tilesOfColumn = new LinkedList<>();
    for (int i = 0; i < numberOfTiles; i++) {
      tilesOfColumn.add(i, retrieveRandomTile());
    }
    return tilesOfColumn;
  }

  private void initNumbers() {
    addNumbersOfType(2, TileNumber.TWO);
    addNumbersOfType(3, TileNumber.THREE);
    addNumbersOfType(3, TileNumber.FOUR);
    addNumbersOfType(3, TileNumber.FIVE);
    addNumbersOfType(3, TileNumber.SIX);
    addNumbersOfType(3, TileNumber.EIGHT);
    addNumbersOfType(3, TileNumber.NINE);
    addNumbersOfType(3, TileNumber.TEN);
    addNumbersOfType(3, TileNumber.ELEVEN);
    addNumbersOfType(2, TileNumber.TWELVE);
  }

  private void addNumbersOfType(int numberOfNumbers, TileNumber tileNumber) {
    for (int i = 0; i < numberOfNumbers; i++) {
      numbers.add(tileNumber);
    }
  }

  private void initTiles() {
    addTilesOfType(19, Landscape.SEA);
    addTilesOfType(2, Landscape.GOLD);
    addTilesOfType(3, Landscape.DESERT);
    addTilesOfType(5, Landscape.FOREST);
    addTilesOfType(5, Landscape.PASTURE);
    addTilesOfType(5, Landscape.FIELD);
    addTilesOfType(5, Landscape.HILLS);
    addTilesOfType(5, Landscape.MOUNTAINS);
  }

  private void addTilesOfType(int numberOfTiles, Landscape landscapeType) {
    for (int i = 0; i < numberOfTiles; i++) {
      TileNumber tileNumber = null;
      if (landscapeType != Landscape.DESERT && landscapeType != Landscape.SEA) {
        tileNumber = retrieveRandomTileNumber();
      }
      Tile tile = new Tile(landscapeType, Harbor.ALL, tileNumber);
      tiles.add(tile);
    }
  }
}
