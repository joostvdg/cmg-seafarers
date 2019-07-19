package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.Game;
import com.github.joostvdg.cmg.seafarers.model.game.NormalGame;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/normal")
public class NormalGameResource {

  @GET
  @Path("/text")
  @Produces(MediaType.TEXT_PLAIN)
  public String normalGameText() {
    Game game = new NormalGame();
    return game.toString();
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Game normalGame() {
    return new NormalGame();
  }
}
