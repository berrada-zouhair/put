package com.put.chapter8.capture.arguments;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Date;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class PimTest {

  private final int ONE_HOUR_IN_MINUTES = 60;
  private final int ONE_HOUR_IN_MILLISECONDS = 60 * 1000;
  private final Date START_DATE = new Date();
  private final Date END_DATE = new Date(START_DATE.getTime() + ONE_HOUR_IN_MILLISECONDS);

  @Test
  void should_add_meeting_to_calendar_with_argument_captor() {
    Calendar calendar = mock(Calendar.class);
    Pim pim = new Pim(calendar);
    ArgumentCaptor<Meeting> argumentCaptor = ArgumentCaptor.forClass(Meeting.class);

    pim.addMeeting(START_DATE, ONE_HOUR_IN_MINUTES);

    verify(calendar).addEvent(argumentCaptor.capture());
    Meeting meeting = argumentCaptor.getValue();
    Assertions.assertThat(meeting.getStartDate()).isEqualTo(START_DATE);
    Assertions.assertThat(meeting.getEndDate()).isEqualTo(END_DATE);

  }

  @Test
  void should_add_meeting_to_calendar_with_hamcrest_matcher() {
    Calendar calendar = mock(Calendar.class);
    Pim pim = new Pim(calendar);

    pim.addMeeting(START_DATE, ONE_HOUR_IN_MINUTES);

    verify(calendar).addEvent(argThat(
        meeting -> meeting.getStartDate().equals(START_DATE) && meeting.getEndDate()
            .equals(END_DATE)));

  }
}
