package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.CREATED;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  private Jsonb jsonb = JsonbBuilder.create();

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test @Disabled("MissingMethodException: No signature of method")
  public void shouldGetCustomers() {
    ArrayList customers =
      given()
        .header(ACCEPT, APPLICATION_JSON).
      when()
        .get("/customers").
      then()
        .statusCode(OK.getStatusCode())
        .extract().body().as(ArrayList.class);

    assertEquals(2, customers.size());

  }

  @Test
  public void shouldGetCustomer() {
    given()
      .header(ACCEPT, APPLICATION_JSON)
      .pathParam("customerId", 1234).
    when()
      .get("/customers/{customerId}").
    then()
      .statusCode(OK.getStatusCode())
      .body("email", Is.is("jsmith@gmail.com"))
      .body("firstName", Is.is("John"))
      .body("lastName", Is.is("Smith"));
  }

  @Test
  public void shouldCreateCustomer() {
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");

    given()
      .body(jsonb.toJson(customer))
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .post("/customers").
    then()
      .statusCode(CREATED.getStatusCode());
  }

  @Test
  public void shouldUpdateCustomer() {
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");

    given()
      .body(jsonb.toJson(customer))
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .header(ACCEPT, APPLICATION_JSON).
    when()
      .put("/customers").
    then()
      .statusCode(OK.getStatusCode())
      .header(CONTENT_TYPE, APPLICATION_JSON)
      .body("firstName", Is.is("JohnUpdated"));
  }

  @Test
  public void shouldDeleteCustomer() {
    // Deletes the previously created book
    given()
      .pathParam("customerId", 1234).
    when()
      .delete("/customers/{customerId}").
    then()
      .statusCode(NO_CONTENT.getStatusCode());
  }
}
