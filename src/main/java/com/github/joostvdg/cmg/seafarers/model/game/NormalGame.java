package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Harbor;
import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import com.google.common.base.Strings;
import java.util.*;

/**
 * NormalGame, a game for up to four players. For inspiration for the maps:
 * http://gemkapocs.keszthelyonline.hu/letoltes/Complete_Scenario_and_Variant_Guide.pdf
 */
public class NormalGame extends AbstractGame implements Game {

  private final Board board;
  private static final int TOTAL_COLUMNS = 11;

  public NormalGame() {
    super();
    initNumbers();
    initTiles();
    this.board = createBoard();
  }

  private final String line01 =
      "...............................................................................................";
  private final String line02 =
      "..........................................__________...........................................";
  private final String line03 =
      "..............................__________ / XXXXXXXXX \\ ___________.............................";
  private final String line04 =
      ".................__________ / XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\ ___________................";
  private final String line05 =
      "....__________ / XXXXXXXXX \\ YYYYYY    // XXXXXXXXX \\ YYYYYY    // XXXXXXXXX \\ __________....";
  private final String line06 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line07 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line08 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line09 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line10 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line11 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line12 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line13 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line14 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line15 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line16 =
      "...............\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /...............";
  private final String line17 =
      "............................\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /............................";
  private final String line18 =
      ".........................................\\ YYYYYY    /.........................................";
  private final String line19 =
      "...............................................................................................";

  @Override
  public String toString() {
    List<String> rowLines = new ArrayList<>();
    rowLines.add(line01);
    rowLines.add(line02);
    rowLines.add(line03);
    rowLines.add(line04);
    rowLines.add(line05);
    rowLines.add(line06);
    rowLines.add(line07);
    rowLines.add(line08);
    rowLines.add(line09);
    rowLines.add(line10);
    rowLines.add(line11);
    rowLines.add(line12);
    rowLines.add(line13);
    rowLines.add(line14);
    rowLines.add(line15);
    rowLines.add(line16);
    rowLines.add(line17);
    rowLines.add(line18);
    rowLines.add(line19);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(line01);
    stringBuilder.append("\n");
    stringBuilder.append(line02);
    stringBuilder.append("\n");
    for (Map.Entry<Integer, List<Tile>> entry : getBoard().getTiles().entrySet()) {
      int rowId = entry.getKey();
      String rowLine = rowLines.get(rowId + 2);

      // First pass: replace tile headers (landscape)
      for (Tile tile : entry.getValue()) {
        String landscapeText = tile.getLandscape().getDisplayName();
        landscapeText = Strings.padEnd(landscapeText, 9, ' ');
        rowLine = rowLine.replaceFirst("XXXXXXXXX", landscapeText);
      }

      // Second pass: retrieve tile number of previous row
      if (rowId != 0) { // skip first one, as there is no previous row
        List<Tile> tilesOfPreviousRow = getBoard().getTiles().get(rowId - 1);
        for (Tile tile : tilesOfPreviousRow) {
          String numberText = "";
          if (tile.hasNumber()) {
            numberText = tile.getNumber().name();
          }
          numberText = Strings.padEnd(numberText, 6, ' ');
          rowLine = rowLine.replaceFirst("YYYYYY", numberText);
        }
      }
      stringBuilder.append(rowLine);
      stringBuilder.append("\n");
    }

    String secondLastRow = line18.replaceFirst("YYYYYY", "      ");
    stringBuilder.append(secondLastRow);
    stringBuilder.append("\n");
    stringBuilder.append(line19);
    stringBuilder.append("\n");
    stringBuilder.append("Game Code: ");
    stringBuilder.append(board.toGameCode());
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }

  private Board createBoard() {
    Map<Integer, List<Tile>> boardTiles = layBoardTiles();
    return new Board(boardTiles);
  }

  private Map<Integer, List<Tile>> layBoardTiles() {
    Map<Integer, List<Tile>> boardTiles = new TreeMap<>();
    Tile firstTile = new Tile(Landscape.SEA, Harbor.NONE, null);
    List<Tile> firstColumn = new ArrayList<>();
    firstColumn.add(firstTile);
    Tile lastTile = new Tile(Landscape.SEA, Harbor.NONE, null);
    List<Tile> lastColumn = new ArrayList<>();
    lastColumn.add(lastTile);

    boardTiles.put(0, firstColumn);
    boardTiles.put(1, createColumnTiles(2));
    boardTiles.put(2, createColumnTiles(3));
    boardTiles.put(3, createColumnTiles(4));
    boardTiles.put(4, createColumnTiles(3));
    boardTiles.put(5, createColumnTiles(4));
    boardTiles.put(6, createColumnTiles(3));
    boardTiles.put(7, createColumnTiles(4));
    boardTiles.put(8, createColumnTiles(3));
    boardTiles.put(9, createColumnTiles(4));
    boardTiles.put(10, createColumnTiles(3));
    boardTiles.put(11, createColumnTiles(4));
    boardTiles.put(12, createColumnTiles(3));
    boardTiles.put(13, createColumnTiles(2));
    boardTiles.put(14, lastColumn);
    return boardTiles;
  }

  protected void initNumbers() {
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

  protected void initTiles() {
    addTilesOfType(17, Landscape.SEA); // first and last tile are required to be wather
    addTilesOfType(2, Landscape.GOLD);
    addTilesOfType(1, Landscape.DESERT);
    addTilesOfType(5, Landscape.FOREST);
    addTilesOfType(5, Landscape.PASTURE);
    addTilesOfType(5, Landscape.FIELD);
    addTilesOfType(5, Landscape.HILLS);
    addTilesOfType(5, Landscape.MOUNTAINS);
  }

  @Override
  public Board getBoard() {
    return this.board;
  }

  @Override
  public String getGameType() {
    return GameType.SEAFARERS_NORMAL.toString();
  }
}
