package com.put.chapter10.complex.object.exercice1;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Builder(builderMethodName = "anOrder", setterPrefix = "with", toBuilder = true)
@Data
public class Order {

  private final Long orderId;
  private final Customer customer;
  @Singular
  private final List<OrderItem> orderItems;
  private final Double discountRate;
  private final String couponCode;

}
