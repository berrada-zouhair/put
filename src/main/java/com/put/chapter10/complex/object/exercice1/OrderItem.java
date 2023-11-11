package com.put.chapter10.complex.object.exercice1;

import lombok.Builder;
import lombok.Data;

@Builder(builderMethodName = "anItem", setterPrefix = "with")
@Data
public class OrderItem {

  private final String name;
  private final int quantity;

}
