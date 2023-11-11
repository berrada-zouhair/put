package com.put.chapter10.complex.object.exercice1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OrderTest {

  @Test
  void name() {
    OrderItem raybi = OrderItems.anItem()
        .withName("Raybi")
//        .withQuantity(2)
        .build();
    OrderItem merandina = OrderItems.anItem()
        .withName("Merandina")
//        .withQuantity(2)
        .build();
    Order snack = Orders.anOrder()
        .withOrderItem(raybi)
        .withOrderItem(merandina)
        .build();

    Order orderWithDiscount = snack.toBuilder().withDiscountRate(0.1).build();
    Order orderWithCoupon = snack.toBuilder().withCouponCode("HALF_OFF").build();

    assertThat(snack.getOrderItems())
        .hasSize(2)
        .containsExactlyInAnyOrder(merandina, raybi);
  }
}
