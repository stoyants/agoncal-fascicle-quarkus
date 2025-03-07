package org.agoncal.fascicle.quarkus.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;

// @formatter:off
// tag::adocSnippet[]
@QuarkusTest
public class BookResourceTest {

  @Test
  void shouldGetRandomBook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/api/books").
    then()
      .statusCode(OK.getStatusCode())
      .body("$", hasKey("isbn_10"))
      .body("$", hasKey("isbn_13"))
      .body("$", hasKey("title"))
      .body("$", hasKey("author"))
      .body("$", hasKey("genre"))
      .body("$", hasKey("publisher"));
  }
  // tag::adocSkip[]

  @Test
  void shouldPingOpenAPI() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/q/openapi").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldPingSwaggerUI() {
    given().
    when()
      .get("/q/swagger-ui").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldPingLiveness() {
    given().
    when()
      .get("/q/health/live").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldPingReadiness() {
    given().
    when()
      .get("/q/health/ready").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }

  @Test
  void shouldPingMetrics() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
    when()
      .get("/q/metrics/application").
    then()
      .statusCode(OK.getStatusCode());
  }

  @Test
  void shouldNotFindDummy() {
    given().
    when()
      .get("/api/books/dummy").
    then()
      .statusCode(NOT_FOUND.getStatusCode());
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
