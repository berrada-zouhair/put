package com.put.chapter10.complex.object.exercice1;

import lombok.Builder;

@Builder(setterPrefix = "with", builderMethodName = "aPerson", toBuilder = true)
public class Person {

  private final String field1;
  private final String field2;
  private final String field3;
  private final String field4;
  private final String field5;
  private final String field6;

}
