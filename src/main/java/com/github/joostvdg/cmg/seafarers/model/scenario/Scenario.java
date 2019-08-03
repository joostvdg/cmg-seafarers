package com.github.joostvdg.cmg.seafarers.model.scenario;

import com.github.joostvdg.cmg.seafarers.model.game.Game;

public interface Scenario {

  Game game();

  String name();

  String code();
}
