package org.keycube.fiasservice.health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.reactive.RestResponse;

@Path("health-prob")
public class HealthResource {

  @GET
  @Path("ready")
  @Produces(MediaType.TEXT_PLAIN)
  @Operation(hidden = true)
  public RestResponse<String> check() {
    return RestResponse.ok("UP");
  }
}
