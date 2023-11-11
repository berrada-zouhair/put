package com.put.chapter5.mocks.exercice2;

import com.put.chapter5.mocks.exapmle2.Client;
import com.put.chapter5.mocks.exapmle2.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class RaceResultService {

  private Map<RaceType, Set<Client>> clientsByRaceType = new HashMap<>();

  public void sendMessage(Message... messages) {
    for (Message message : messages) {
      Optional<Set<Client>> clients = Optional
          .ofNullable(clientsByRaceType.get(message.getRaceType()));
      clients.ifPresent(clients1 -> clients1.forEach(client -> client.receiveMessage(message)));
    }
  }

  public void addSubscriber(Client client, RaceType... racesType) {
    for (RaceType raceType : racesType) {
      Set<Client> subscribers = clientsByRaceType.getOrDefault(raceType, new HashSet<>());
      subscribers.add(client);
      clientsByRaceType.put(raceType, subscribers);
    }
  }
}
