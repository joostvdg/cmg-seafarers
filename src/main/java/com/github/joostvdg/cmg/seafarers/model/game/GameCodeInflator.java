package com.github.joostvdg.cmg.seafarers.model.game;

import com.google.common.base.Strings;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class GameCodeInflator {

  private static final Logger LOG = Logger.getLogger(GameCodeInflator.class.getName());
  private static final Map<Integer, GameType> CODE_TO_GAME_TYPE;
  private final GameType gameType;
  private Game game;

  static {
    CODE_TO_GAME_TYPE = new TreeMap<>();
    CODE_TO_GAME_TYPE.put(NormalGame.NUMBER_OF_TILES * 2, GameType.SEAFARERS_NORMAL);
    CODE_TO_GAME_TYPE.put(LargeGame.NUMBER_OF_TILES * 2, GameType.SEAFARERS_LARGE);
    CODE_TO_GAME_TYPE.put(SmallGame.NUMBER_OF_TILES * 2, GameType.SEAFARERS_SMALL);
  }

  public GameCodeInflator(final String code) {
    LOG.info("Attempt to inflate game based on code: " + code);
    if (Strings.isNullOrEmpty(code)) {
      throw new IllegalArgumentException("There's no code");
    }
    GameType gameType = CODE_TO_GAME_TYPE.get(code.length());
    if (gameType == null) {
      throw new IllegalArgumentException("Code does not match any game type");
    }
    this.gameType = gameType;

    switch (gameType) {
      case SEAFARERS_LARGE:
        this.game = new LargeGame(code);
        break;
      case SEAFARERS_NORMAL:
        LOG.info("Inflating Normal Game");
        this.game = new NormalGame(code);
        break;
      case SEAFARERS_SMALL:
        LOG.info("Inflating Small Game");
        this.game = new SmallGame(code);
        break;
    }
  }

  public Game getGame() {
    return game;
  }

  public GameType getGameType() {
    return gameType;
  }
}
