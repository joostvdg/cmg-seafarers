package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Landscape;
import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import com.github.joostvdg.cmg.seafarers.model.pieces.TileNumber;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RegisterForReflection
public class Board {

  private final Map<Integer, List<Tile>> tiles;

  private String code = "N/A";

  public Board(Map<Integer, List<Tile>> tiles) {
    this.tiles = tiles;
  }

  public String getCode() {
    if (code.equals("N/A")) { // lazy init
      toGameCode();
    }
    return code;
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
    LANDSCAPE_STRING_MAP.put(Landscape.FOREST, "1");
    LANDSCAPE_STRING_MAP_REVERSE.put("1", Landscape.FOREST);
    LANDSCAPE_STRING_MAP.put(Landscape.PASTURE, "2");
    LANDSCAPE_STRING_MAP_REVERSE.put("2", Landscape.PASTURE);
    LANDSCAPE_STRING_MAP.put(Landscape.FIELD, "3");
    LANDSCAPE_STRING_MAP_REVERSE.put("3", Landscape.FIELD);
    LANDSCAPE_STRING_MAP.put(Landscape.HILLS, "4");
    LANDSCAPE_STRING_MAP_REVERSE.put("4", Landscape.HILLS);
    LANDSCAPE_STRING_MAP.put(Landscape.MOUNTAINS, "5");
    LANDSCAPE_STRING_MAP_REVERSE.put("5", Landscape.MOUNTAINS);
    LANDSCAPE_STRING_MAP.put(Landscape.DESERT, "6");
    LANDSCAPE_STRING_MAP_REVERSE.put("6", Landscape.DESERT);
    LANDSCAPE_STRING_MAP.put(Landscape.SEA, "7");
    LANDSCAPE_STRING_MAP_REVERSE.put("7", Landscape.SEA);
    LANDSCAPE_STRING_MAP.put(Landscape.GOLD, "8");
    LANDSCAPE_STRING_MAP_REVERSE.put("8", Landscape.GOLD);
  }

  static {
    TILE_NUMBER_STRING_MAP = new TreeMap<>();
    TILE_NUMBER_STRING_MAP_REVERSE = new TreeMap<>();
    TILE_NUMBER_STRING_MAP.put(TileNumber.TWO, "a");
    TILE_NUMBER_STRING_MAP_REVERSE.put("a", TileNumber.TWO);
    TILE_NUMBER_STRING_MAP.put(TileNumber.THREE, "b");
    TILE_NUMBER_STRING_MAP_REVERSE.put("b", TileNumber.THREE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.FOUR, "c");
    TILE_NUMBER_STRING_MAP_REVERSE.put("c", TileNumber.FOUR);
    TILE_NUMBER_STRING_MAP.put(TileNumber.FIVE, "d");
    TILE_NUMBER_STRING_MAP_REVERSE.put("d", TileNumber.FIVE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.SIX, "e");
    TILE_NUMBER_STRING_MAP_REVERSE.put("e", TileNumber.SIX);
    TILE_NUMBER_STRING_MAP.put(TileNumber.EIGHT, "f");
    TILE_NUMBER_STRING_MAP_REVERSE.put("f", TileNumber.EIGHT);
    TILE_NUMBER_STRING_MAP.put(TileNumber.NINE, "g");
    TILE_NUMBER_STRING_MAP_REVERSE.put("g", TileNumber.NINE);
    TILE_NUMBER_STRING_MAP.put(TileNumber.TEN, "h");
    TILE_NUMBER_STRING_MAP_REVERSE.put("h", TileNumber.TEN);
    TILE_NUMBER_STRING_MAP.put(TileNumber.ELEVEN, "i");
    TILE_NUMBER_STRING_MAP_REVERSE.put("i", TileNumber.ELEVEN);
    TILE_NUMBER_STRING_MAP.put(TileNumber.TWELVE, "j");
    TILE_NUMBER_STRING_MAP_REVERSE.put("j", TileNumber.TWELVE);
    // TILE_NUMBER_STRING_MAP.put(null, "p");
    TILE_NUMBER_STRING_MAP_REVERSE.put("z", null);
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
        String code = LANDSCAPE_STRING_MAP.get(tile.getLandscape());
        builder.append(code);
        if (tile.getNumber() != null) {
          builder.append(TILE_NUMBER_STRING_MAP.get(tile.getNumber()));
        } else {
          builder.append("p");
        }
      }
    }
    this.code = builder.toString();
    return this.code;
  }
}
