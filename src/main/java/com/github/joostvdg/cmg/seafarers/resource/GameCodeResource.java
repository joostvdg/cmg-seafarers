package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.GameCodeInflator;
import io.sentry.Sentry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/code")
public class GameCodeResource {

  private static final Logger logger = Logger.getLogger(GameCodeResource.class.getName());

  @GET
  @Path("/{code}")
  @Produces(MediaType.TEXT_PLAIN)
  public Response retrieveGameByCode(@PathParam("code") String code) {
    try {
      GameCodeInflator inflator = new GameCodeInflator(code);
      String inflatedGame =
          "GameType: " + inflator.getGameType() + "\n" + inflator.getGame().toString();
      return Response.ok(inflatedGame).build();
    } catch (Exception e) {
      String errorMessage = "Could not inflate game via given code";
      logger.log(Level.WARNING, errorMessage + ": " + e.getMessage());
      Sentry.capture(e);
      return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
          .entity(errorMessage + ": " + e.getMessage())
          .build();
    }
  }
}
