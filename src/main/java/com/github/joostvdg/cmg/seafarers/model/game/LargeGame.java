package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jboss.resteasy.spi.NotImplementedYetException;

public class LargeGame extends AbstractGame implements Game {

  private final Board board;
  // 10 + (9*2) + (8*2) + (7*2)
  public static final int NUMBER_OF_TILES = 58;

  private static final List<BoardRow> boardRows;

  static {
    boardRows = new ArrayList<>();
    boardRows.add(new BoardRow(0, 1));
    boardRows.add(new BoardRow(1, 2));
    boardRows.add(new BoardRow(2, 3));
    boardRows.add(new BoardRow(3, 4));
    boardRows.add(new BoardRow(4, 3));
    boardRows.add(new BoardRow(5, 4));
    boardRows.add(new BoardRow(6, 3));
    boardRows.add(new BoardRow(7, 4));
    boardRows.add(new BoardRow(8, 3));
    boardRows.add(new BoardRow(9, 4));
    boardRows.add(new BoardRow(10, 3));
    boardRows.add(new BoardRow(11, 4));
    boardRows.add(new BoardRow(12, 3));
    boardRows.add(new BoardRow(13, 4));
    boardRows.add(new BoardRow(14, 3));
    boardRows.add(new BoardRow(15, 4));
    boardRows.add(new BoardRow(16, 3));
    boardRows.add(new BoardRow(17, 2));
    boardRows.add(new BoardRow(18, 1));
  }

  public LargeGame() {
    super();
    initNumbers();
    initTiles();
    this.board = createBoard();
  }

  public LargeGame(String code) {
    Map<Integer, List<Tile>> boardTiles = new TreeMap<>();

    int codeIndex = 0;
    for (BoardRow row : boardRows) {
      List<Tile> tilesOfRow = inflateTilesForRow(code, codeIndex, row);
      codeIndex = codeIndex + tilesOfRow.size() * 2;
      boardTiles.put(row.getRowId(), tilesOfRow);
    }
    this.board = new Board(boardTiles);
  }

  @Override
  public Board getBoard() {
    return this.board;
  }

  @Override
  public String getGameType() {
    return GameType.SEAFARERS_LARGE.toString();
  }

  private Board createBoard() {
    Map<Integer, List<Tile>> boardTiles = layBoardTiles();
    return new Board(boardTiles);
  }

  public Board getBoardByCode(String code) {
    throw new NotImplementedYetException("This game type doesn't support inflation yet");
  }

  protected void initNumbers() {}

  protected void initTiles() {}

  protected List<BoardRow> boardRows() {
    return boardRows;
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
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line17 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line18 =
      "../ XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\..";
  private final String line19 =
      "..\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /..";
  private final String line20 =
      "...............\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /...............";
  private final String line21 =
      "............................\\ YYYYYY    // XXXXXXXXX \\\\ YYYYYY    /............................";
  private final String line22 =
      ".........................................\\ YYYYYY    /.........................................";
  private final String line23 =
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
    rowLines.add(line20);
    rowLines.add(line21);
    rowLines.add(line22);
    rowLines.add(line23);

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

    String secondLastRow = line22.replaceFirst("YYYYYY", "      ");
    stringBuilder.append(secondLastRow);
    stringBuilder.append("\n");
    stringBuilder.append(line23);
    stringBuilder.append("\n");
    stringBuilder.append("Game Code: ");
    stringBuilder.append(board.toGameCode());
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }
}
