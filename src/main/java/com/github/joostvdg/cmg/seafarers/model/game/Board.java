package com.github.joostvdg.cmg.seafarers.model.game;

import com.github.joostvdg.cmg.seafarers.model.pieces.Tile;
import java.util.List;
import java.util.Map;

public class Board {

  private Map<String, List<Tile>> board;

  public Board(Map<String, List<Tile>> board) {
    this.board = board;
  }

  public Map<String, List<Tile>> getBoard() {
    return board;
  }
}
