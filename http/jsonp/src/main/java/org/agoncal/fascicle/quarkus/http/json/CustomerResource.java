package org.agoncal.fascicle.quarkus.http.json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Path("/getCustomer")
  // tag::adocGetCustomer[]
  @GET
  public Response getCustomer() {
    JsonObject customer = Json.createObjectBuilder()
      .add("firstName", "Antonio")
      .add("lastName", "Goncalves")
      .add("email", "agoncal.fascicle@gmail.com")
      .add("address", Json.createObjectBuilder()
        .add("street", "21 Ritherdon Rd")
        .add("city", "Brighton")
        .add("country", "UK"))
      .add("phoneNumbers", Json.createArrayBuilder()
        .add(Json.createObjectBuilder()
          .add("type", "mobile")
          .add("number", "+33 123 456"))
        .add(Json.createObjectBuilder()
          .add("type", "home")
          .add("number", "+33 646 555")))
      .build();
    return Response.ok(customer).build();
  }
  // end::adocGetCustomer[]

  @Path("/getPhones")
  // tag::adocGetPhones[]
  @GET
  public Response getPhones() {
    JsonArray phones =  Json.createArrayBuilder()
        .add(Json.createObjectBuilder()
          .add("type", "mobile")
          .add("number", "+33 123 456"))
        .add(Json.createObjectBuilder()
          .add("type", "home")
          .add("number", "+33 646 555"))
      .build();
    return Response.ok(phones).build();
  }
  // end::adocGetPhones[]
}
