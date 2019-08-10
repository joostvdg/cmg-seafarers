package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.game.Scenario;
import com.github.joostvdg.cmg.seafarers.model.game.Scenarios;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/scenario")
public class ScenarioResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Scenario> getScenerarios() {
    return Scenarios.SCENARIOS;
  }
}
