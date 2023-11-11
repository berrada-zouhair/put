package com.put.chapter10.complex.object.exercice1;

public class Customers {

  static Customer.CustomerBuilder aCustomer() {
    return Customer.builder()
        .customerId(1L)
        .name("any_name")
        .address(Addresses.anAddress().build());
  }

}
