package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Board {

  private Map<Integer, List<Tile>> tiles;

  public Board(Map<Integer, List<Tile>> tiles) {
    this.tiles = tiles;
  }

  public Map<Integer, List<Tile>> getTiles() {
    return tiles;
  }

  private static final Map<Landscape, String> LANDSCAPE_STRING_MAP;
  public static final Map<String, Landscape> LANDSCAPE_STRING_MAP_REVERSE;
  private static final Map<TileNumber, String> TILE_NUMBER_STRING_MAP;
  public static final Map<String, TileNumber> TILE_NUMBER_STRING_MAP_REVERSE;

  static {
    LANDSCAPE_STRING_MAP = new TreeMap<>();
    LANDSCAPE_STRING_MAP_REVERSE = new TreeMap<>();
    LANDSCAPE_STRING_MAP.put(Landscape.GOLD, "a");
    LANDSCAPE_STRING_MAP_REVERSE.put("a", Landscape.GOLD);
    LANDSCAPE_STRING_MAP.put(Landscape.DESERT, "b");
    LANDSCAPE_STRING_MAP_REVERSE.put("b", Landscape.DESERT);
    LANDSCAPE_STRING_MAP.put(Landscape.FIELD, "c");
    LANDSCAPE_STRING_MAP_REVERSE.put("c", Landscape.FIELD);
    LANDSCAPE_STRING_MAP.put(Landscape.FOREST, "d");
    LANDSCAPE_STRING_MAP_REVERSE.put("d", Landscape.FOREST);
    LANDSCAPE_STRING_MAP.put(Landscape.PASTURE, "e");
    LANDSCAPE_STRING_MAP_REVERSE.put("e", Landscape.PASTURE);
    LANDSCAPE_STRING_MAP.put(Landscape.MOUNTAINS, "f");
    LANDSCAPE_STRING_MAP_REVERSE.put("f", Landscape.MOUNTAINS);
    LANDSCAPE_STRING_MAP.put(Landscape.HILLS, "g");
    LANDSCAPE_STRING_MAP_REVERSE.put("g", Landscape.HILLS);
    LANDSCAPE_STRING_MAP.put(Landscape.SEA, "h");
    LANDSCAPE_STRING_MAP_REVERSE.put("h", Landscape.SEA);
  }

  static {
    TILE_NUMBER_STRING_MAP = new TreeMap<>();
    TILE_NUMBER_STRING_MAP_REVERSE = new TreeMap<>();
    TILE_NUMBER_STRING_MAP.put(TileNumber.TWO, "z");
    TILE_NUMBER_STRING_MAP_REVERSE.put("z", TileNumber.TWO);
    TILE_NUMBER_STRING_MAP.put(TileNumber.THREE, "y");
    TILE_NUMBER_STRING_MAP_REVERSE.put("y", TileNumber.THREE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.FOUR, "x");
    TILE_NUMBER_STRING_MAP_REVERSE.put("x", TileNumber.FOUR);
    TILE_NUMBER_STRING_MAP.put(TileNumber.FIVE, "w");
    TILE_NUMBER_STRING_MAP_REVERSE.put("w", TileNumber.FIVE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.SIX, "v");
    TILE_NUMBER_STRING_MAP_REVERSE.put("v", TileNumber.SIX);
    TILE_NUMBER_STRING_MAP.put(TileNumber.EIGHT, "u");
    TILE_NUMBER_STRING_MAP_REVERSE.put("u", TileNumber.EIGHT);
    TILE_NUMBER_STRING_MAP.put(TileNumber.NINE, "t");
    TILE_NUMBER_STRING_MAP_REVERSE.put("t", TileNumber.NINE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.TEN, "s");
    TILE_NUMBER_STRING_MAP_REVERSE.put("s", TileNumber.TEN);
    TILE_NUMBER_STRING_MAP.put(TileNumber.ELEVEN, "r");
    TILE_NUMBER_STRING_MAP_REVERSE.put("r", TileNumber.ELEVEN);
    TILE_NUMBER_STRING_MAP.put(TileNumber.TWELVE, "q");
    TILE_NUMBER_STRING_MAP_REVERSE.put("q", TileNumber.TWELVE);
    // TILE_NUMBER_STRING_MAP.put(null, "p");
    TILE_NUMBER_STRING_MAP_REVERSE.put("p", null);
  }

  /**
   * Translates the current game board to a game code.
   *
   * @return
   */
  public String toGameCode() {
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<Integer, List<Tile>> entry : tiles.entrySet()) {
      for (Tile tile : entry.getValue()) {
        builder.append(LANDSCAPE_STRING_MAP.get(tile.getLandscape()));
        if (tile.getNumber() != null) {
          builder.append(TILE_NUMBER_STRING_MAP.get(tile.getNumber()));
        } else {
          builder.append("p");
        }
      }
    }
    return builder.toString();
  }
}
