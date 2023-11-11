package com.put.chapter10.complex.object.exercice2;

public class Transactions {

  public static Transaction.TransactionBuilder aTransaction() {
    return Transaction.builder()
        .withBillingId("any_billing_id")
        .withMessage("any_message")
        .withRetryAllowed(true)
        .withId(1L)
        .withState(State.OK);
  }

  public static Transaction okTransaction() {
    return aTransaction().withState(State.OK).build();
  }

  public static Transaction canceledTransaction() {
    return aTransaction().withState(State.CANCELED).build();
  }

  public static Transaction errorTransaction() {
    return aTransaction().withState(State.ERROR).build();
  }

  public static Transaction processingTransaction() {
    return aTransaction().withState(State.PROCESSING).build();
  }

}
