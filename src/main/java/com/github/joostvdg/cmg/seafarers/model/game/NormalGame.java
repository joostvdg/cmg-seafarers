package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import com.google.common.base.Strings;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NormalGame, a game for up to four players. For inspiration for the maps:
 * http://gemkapocs.keszthelyonline.hu/letoltes/Complete_Scenario_and_Variant_Guide.pdf
 */
@RegisterForReflection
public class NormalGame extends AbstractGame implements Game {

  private static Logger LOGGER = Logger.getLogger(NormalGame.class.getName());

  private final Board board;
  public static final int NUMBER_OF_TILES = 44;
  private static final List<BoardRow> boardRows;

  static {
    boardRows = new ArrayList<>();
    boardRows.add(new BoardRow(0, 5));
    boardRows.add(new BoardRow(1, 6));
    boardRows.add(new BoardRow(2, 7));
    boardRows.add(new BoardRow(3, 8));
    boardRows.add(new BoardRow(4, 7));
    boardRows.add(new BoardRow(5, 6));
    boardRows.add(new BoardRow(6, 5));
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
      "....__________ / XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\ __________....";
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

  public NormalGame() {
    super();
    initNumbers();
    initTiles();
    this.board = createBoard();
  }

  public NormalGame(String code) {
    Map<Integer, List<Tile>> boardTiles = new TreeMap<>();

    int codeIndex = 0;
    for (BoardRow row : boardRows) {
      List<Tile> tilesOfRow = inflateTilesForRow(code, codeIndex, row);
      codeIndex = codeIndex + tilesOfRow.size() * 2;
      boardTiles.put(row.getRowId(), tilesOfRow);
      LOGGER.log(
          Level.INFO, String.format("Row %d added %d tiles", row.getRowId(), tilesOfRow.size()));
    }

    this.board = new Board(boardTiles);
  }

  private Board createBoard() {
    Map<Integer, List<Tile>> boardTiles = layBoardTiles();
    return new Board(boardTiles);
  }

  protected List<BoardRow> boardRows() {
    return boardRows;
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
    addNumbersOfType(1, TileNumber.TWELVE);
  }

  protected void initTiles() {
    addTilesOfType(16, Landscape.SEA);
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
}
