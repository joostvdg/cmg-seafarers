package com.github.joostvdg.cmg.seafarers.model.game;

import com.google.common.base.Strings;
import java.util.Map;
import java.util.TreeMap;

public class GameCodeInflator {

  private static final Map<Integer, GameType> CODE_TO_GAME_TYPE;
  private final GameType gameType;
  private final String code;
  private Game game;

  static {
    CODE_TO_GAME_TYPE = new TreeMap<>();
    CODE_TO_GAME_TYPE.put(NormalGame.NUMBER_OF_TILES * 2, GameType.SEAFARERS_NORMAL);
    CODE_TO_GAME_TYPE.put(LargeGame.NUMBER_OF_TILES * 2, GameType.SEAFARERS_LARGE);
  }

  public GameCodeInflator(String code) {
    if (Strings.isNullOrEmpty(code)) {
      throw new IllegalArgumentException("There's no code");
    }
    GameType gameType = CODE_TO_GAME_TYPE.get(code.length());
    if (gameType == null) {
      throw new IllegalArgumentException("Code does not match any game type");
    }
    this.gameType = gameType;
    this.code = code;

    if (gameType.equals(GameType.SEAFARERS_NORMAL)) {
      this.game = new NormalGame(code);
    }
  }

  public Game getGame() {
    return game;
  }

  public GameType getGameType() {
    return gameType;
  }
}
