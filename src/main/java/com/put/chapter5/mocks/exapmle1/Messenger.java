package com.put.chapter5.mocks.exapmle1;

public class Messenger {

  private final TemplateEngine templateEngine;
  private final MailServer mailServer;

  public Messenger(TemplateEngine templateEngine, MailServer mailServer) {
    this.templateEngine = templateEngine;
    this.mailServer = mailServer;
  }

  public void sendMessage(Client client, Template template) {
    String message = templateEngine.prepareMessage(template, client);
    mailServer.send(client.getEmail(), message);
  }
}
