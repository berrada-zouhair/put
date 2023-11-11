package com.put.chapter5.mocks.exapmle2;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultService {

  private Collection<Client> clients;

  public RaceResultService() {
    clients = new HashSet<>();
  }

  public void addSubscriber(Client client) {
    clients.add(client);
  }

  public void sendMessage(Message message) {
    clients.forEach(client -> client.receiveMessage(message));
  }

  public void removeSubscriber(Client client) {
    clients.remove(client);
  }
}
