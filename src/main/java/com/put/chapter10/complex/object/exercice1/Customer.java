package com.put.chapter10.complex.object.exercice1;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {

  private final Long customerId;
  private final String name;
  private final Address address;

}
