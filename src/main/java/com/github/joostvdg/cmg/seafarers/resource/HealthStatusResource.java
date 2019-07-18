package com.github.joostvdg.cmg.seafarers.resource;

import com.github.joostvdg.cmg.seafarers.model.HealthStatus;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/health")
public class HealthStatusResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public HealthStatus healthStatus() {
    return new HealthStatus("ok");
  }
}
