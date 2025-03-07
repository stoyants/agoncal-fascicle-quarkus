package org.agoncal.fascicle.quarkus.observability.health.response;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Instant;

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

  @GET
  @Path("/issn")
  public JsonObject generateIssn() {
    return Json.createObjectBuilder()
      .add("isbn10", "dummy")
      .add("generatedAt", String.valueOf(Instant.now()))
      .build();
  }
}
