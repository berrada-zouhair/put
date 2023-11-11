package com.put.chapter9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

  @Test
  void should_test_clients_equality_by_fields() {
    Client client1 = new Client("firstName1", "lastName1");
    Client client2 = new Client("firstName1", "lastName1");
    Assertions.assertThat(client1).usingRecursiveComparison().isEqualTo(client2);
    Assertions.assertThat(client1).isNotEqualTo(client2);
  }
}
