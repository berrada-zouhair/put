package com.put.chapter5.mocks.exapmle1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MessengerTest {

  @Test
  void mocks_should_be_of_same_type_of_requested_class() {
    MailServer mailServer = mock(MailServer.class);
    TemplateEngine templateEngine = mock(TemplateEngine.class);
    Assertions.assertThat(mailServer).isInstanceOf(MailServer.class);
    Assertions.assertThat(templateEngine).isInstanceOf(TemplateEngine.class);
  }

  @Test
  void should_send_message() {
    String sentMessage = "some message";
    String clientEmail = "zouhair@mail.com";
    TemplateEngine templateEngine = mock(TemplateEngine.class);
    MailServer mailServer = mock(MailServer.class);
    Client client = mock(Client.class);
    Template template = mock(Template.class);
    when(templateEngine.prepareMessage(template, client)).thenReturn(sentMessage);
    when(client.getEmail()).thenReturn(clientEmail);

    Messenger messenger = new Messenger(templateEngine, mailServer);
    messenger.sendMessage(client, template);

    verify(templateEngine).prepareMessage(template, client);
    verify(mailServer).send(clientEmail, sentMessage);


  }
}
