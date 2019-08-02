package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Harbor;
import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LargeGame extends AbstractGame implements Game {

  private final Board board;
  private static final int TOTAL_COLUMNS = 11;

  public LargeGame() {
    super();
    //        initNumbers();
    //        initTiles();
    this.board = createBoard();
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

  protected void initNumbers() {}

  protected void initTiles() {}

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
    boardTiles.put(13, createColumnTiles(4));
    boardTiles.put(14, createColumnTiles(3));
    boardTiles.put(15, createColumnTiles(4));
    boardTiles.put(16, createColumnTiles(3));
    boardTiles.put(17, createColumnTiles(2));
    boardTiles.put(18, lastColumn);
    return boardTiles;
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
}
