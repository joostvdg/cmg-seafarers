package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.GameCodeInflator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/code")
public class GameCodeResource {

  @GET
  @Path("/{code}")
  @Produces(MediaType.TEXT_PLAIN)
  public String retrieveGameByCode(@PathParam("code") String code) {
    GameCodeInflator inflator = new GameCodeInflator(code);
    return "GameType: " + inflator.getGameType() + "\n" + inflator.getGame().toString();
  }
}
