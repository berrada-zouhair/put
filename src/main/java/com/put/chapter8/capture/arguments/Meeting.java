package com.put.chapter8.capture.arguments;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Meeting {

  private final Date startDate;
  private final Date endDate;


}
