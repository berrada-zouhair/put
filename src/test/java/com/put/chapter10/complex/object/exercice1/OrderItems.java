package com.put.chapter10.complex.object.exercice1;

import com.put.chapter10.complex.object.exercice1.OrderItem;

class OrderItems {

  static OrderItem.OrderItemBuilder anItem() {
    return OrderItem.anItem()
        .withName("any_name")
        .withQuantity(1);
  }
}
