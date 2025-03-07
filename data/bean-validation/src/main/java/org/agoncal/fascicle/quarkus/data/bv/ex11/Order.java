package org.agoncal.fascicle.quarkus.data.bv.ex11;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Order {

  @NotNull
  public Long id;
  public Double totalAmount;

  @NotNull @Valid
  public Address deliveryAddress;

  public List<@Valid OrderLine> orderLines;

  // tag::adocSkip[]
  // @formatter:on

  public Order() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Order id(Long id) {
    this.id = id;
    return this;
  }

  public Order totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  public void add(OrderLine orderLine) {
    if (this.orderLines == null)
      this.orderLines = new ArrayList<>();
    orderLines.add(orderLine);
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
