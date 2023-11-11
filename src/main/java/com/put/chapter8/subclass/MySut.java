package com.put.chapter8.subclass;

public class MySut {

  public MySut() {
  }

  MyCollaborator createCollaborator() {
    return new MyCollaborator();
  }

  public boolean doSomething() {
    MyCollaborator collaborator = createCollaborator();
    return collaborator.getState();
  }

}
