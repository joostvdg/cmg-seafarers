package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.Game;
import com.github.joostvdg.cmg.seafarers.model.game.NormalGame;
import io.sentry.Sentry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/normal")
public class NormalGameResource {

  private static final Logger logger = Logger.getLogger(NormalGameResource.class.getName());

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response normalGame(@QueryParam("text") boolean text) {
    try {
      Game game = new NormalGame();
      if (text) {
        return Response.ok(game.toString())
            .header("Content-Type", "text/plain; charset=UTF-8")
            .build();
      }
      return Response.ok(game).build();
    } catch (Exception e) {
      String errorMessage = "Could not generate Normal Game";
      logger.log(Level.SEVERE, errorMessage + ": " + e.getMessage());
      Sentry.capture(e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
          .entity(errorMessage + ": " + e.getMessage())
          .build();
    }
  }
}
