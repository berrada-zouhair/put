package com.put.chapter8.capture.arguments;

import java.util.Date;

public class Pim {

  private Calendar calendar;

  public Pim(Calendar calendar) {
    this.calendar = calendar;
  }

  public void addMeeting(Date startDate, int durationInMinutes) {
    Date endDate = new Date(startDate.getTime() + durationInMinutes * 1000);
    calendar.addEvent(new Meeting(startDate, endDate));
  }
}
