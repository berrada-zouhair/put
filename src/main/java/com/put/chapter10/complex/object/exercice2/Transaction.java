package com.put.chapter10.complex.object.exercice2;

import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "with", toBuilder = true)
@Data
public class Transaction {

  private Long id;
  private State state;
  private boolean retryAllowed;
  private String message;
  private String billingId;

}
