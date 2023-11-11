package com.put.chapter10.complex.object.exercice1;

import static com.put.chapter10.complex.object.exercice1.Customers.aCustomer;

class Orders {

  static Order.OrderBuilder anOrder() {
//    return Order.anOrder().orderItem(OrderItems.anItem().build());
    return Order.anOrder()
        .withCustomer(aCustomer().build())
        .withDiscountRate(Double.valueOf("0"));
  }
}
