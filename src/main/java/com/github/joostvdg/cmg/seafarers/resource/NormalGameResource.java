package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.NormalGame;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/normal/")
public class NormalGameResource {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String normalGame() {
    return new NormalGame().toString();
  }
}
