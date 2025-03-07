package org.agoncal.fascicle.quarkus.http.jsonb.advanced;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class Person {

  @JsonbProperty("first_name")
  protected String firstName;
  @JsonbProperty("last_name")
  protected String lastName;
}
