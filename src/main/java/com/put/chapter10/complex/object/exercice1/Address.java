package com.put.chapter10.complex.object.exercice1;

import lombok.Builder;
import lombok.Data;

@Builder()
@Data
public class Address {

  private final String street;
  private final String city;
  private final String zipCode;
  private final String country;

}
