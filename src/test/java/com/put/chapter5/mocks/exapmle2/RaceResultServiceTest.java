package com.put.chapter5.mocks.exapmle2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
  void subscribed_client_should_receive_message() {
    Message message = mock(Message.class);

    raceResultService.addSubscriber(client1);
    raceResultService.sendMessage(message);

    verify(client1).receiveMessage(message);
  }

  @Test
  void message_should_be_sent_to_all_subscribers() {
    Message message = mock(Message.class);

    raceResultService.addSubscriber(client1);
    raceResultService.addSubscriber(client2);
    raceResultService.sendMessage(message);

    verify(client1).receiveMessage(message);
    verify(client2).receiveMessage(message);
  }

  @Test
  void should_send_only_one_message_to_multi_subscriber() {
    Message message = mock(Message.class);

    raceResultService.addSubscriber(client1);
    raceResultService.addSubscriber(client1);
    raceResultService.sendMessage(message);

    verify(client1, times(1)).receiveMessage(message);
  }

  @Test
  void unsubscribed_clients_should_not_receive_message() {
    Message message = mock(Message.class);

    raceResultService.addSubscriber(client1);
    raceResultService.removeSubscriber(client1);
    raceResultService.sendMessage(message);

    verify(client1, never()).receiveMessage(message);
  }
}
