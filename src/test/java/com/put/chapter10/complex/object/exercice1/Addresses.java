package com.put.chapter10.complex.object.exercice1;

import com.put.chapter10.complex.object.exercice1.Address;

public class Addresses {

  static Address.AddressBuilder anAddress() {
    return Address.builder()
        .city("any_city")
        .country("any_country")
        .street("any_street")
        .zipCode("any_zip");
  }

}
