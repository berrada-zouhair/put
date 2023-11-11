package com.put.chapter5.mocks.exercice2;

import static com.put.chapter5.mocks.exercice2.RaceType.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.put.chapter5.mocks.exapmle2.Client;
import com.put.chapter5.mocks.exapmle2.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceResultServiceTest {

  private RaceResultService raceResultService;
  private Client client1 = mock(Client.class, "client1");
  private Client client2 = mock(Client.class, "client2");

  @BeforeEach
  void setUp() {
    raceResultService = new RaceResultService();
  }

  @Test
  void not_subscribed_clients_should_not_receive_message() {
    Message message = mock(Message.class);

    raceResultService.sendMessage(message);

    verify(client1, never()).receiveMessage(message);
    verify(client2, never()).receiveMessage(message);
  }

  @Test
  void subscribed_client_should_receive_message_related_to_topic() {
    Message message = mock(Message.class);
    when(message.getRaceType()).thenReturn(HORSE);

    raceResultService.addSubscriber(client1, HORSE);
    raceResultService.sendMessage(message);

    verify(client1).receiveMessage(message);
  }

  @Test
  void subscribed_client_should_receive_messages_related_to_topics() {
    Message message1 = mock(Message.class);
    when(message1.getRaceType()).thenReturn(HORSE);
    Message message2 = mock(Message.class);
    when(message2.getRaceType()).thenReturn(F1);

    raceResultService.addSubscriber(client1, HORSE, F1);
    raceResultService.sendMessage(message1, message2);

    verify(client1).receiveMessage(message1);
    verify(client1).receiveMessage(message2);
  }

  @Test
  void subscribed_client_should_only_receive_message_related_() {
    Message message1 = mock(Message.class);
    when(message1.getRaceType()).thenReturn(HORSE);
    Message message2 = mock(Message.class);
    when(message2.getRaceType()).thenReturn(F1);

    raceResultService.addSubscriber(client1, HORSE, F1);
    raceResultService.sendMessage(message1, message2);

    verify(client1).receiveMessage(message1);
    verify(client1).receiveMessage(message2);
  }

}
