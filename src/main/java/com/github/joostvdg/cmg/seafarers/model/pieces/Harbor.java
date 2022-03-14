package com.github.joostvdg.cmg.seafarers.model.pieces;

import static com.github.joostvdg.cmg.seafarers.model.pieces.Resource.*;

public enum Harbor {
  ALL(ANY),
  LUMBER(com.github.joostvdg.cmg.seafarers.model.pieces.Resource.LUMBER),
  WOOL(com.github.joostvdg.cmg.seafarers.model.pieces.Resource.WOOL),
  GRAIN(com.github.joostvdg.cmg.seafarers.model.pieces.Resource.GRAIN),
  BRICK(com.github.joostvdg.cmg.seafarers.model.pieces.Resource.BRICK),
  ORE(com.github.joostvdg.cmg.seafarers.model.pieces.Resource.ORE),
  NONE(DESERT);

  private final Resource resource;

  private Harbor(Resource resource) {
    this.resource = resource;
  }
}
