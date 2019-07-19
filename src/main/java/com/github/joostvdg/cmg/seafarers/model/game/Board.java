package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import java.util.List;
import java.util.Map;

public class Board {

  private Map<Integer, List<Tile>> tiles;

  public Board(Map<Integer, List<Tile>> tiles) {
    this.tiles = tiles;
  }

  public Map<Integer, List<Tile>> getTiles() {
    return tiles;
  }
}
