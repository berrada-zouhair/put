package com.put.chapter8.subclass;

//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.when;

import info.solidsoft.mockito.java8.api.WithMockito;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MySutTest implements WithMockito { // no need of static import

  private MyCollaborator collaborator;

  class MySutSubClassed extends MySut {

    @Override
    MyCollaborator createCollaborator() {
      return collaborator;
    }
  }

  @Test
  void should_mock_collaborator_created_inside_method() {
    collaborator = when(mock(MyCollaborator.class).getState()).thenReturn(true).getMock();
//    when(collaborator.getState()).thenReturn(true);
    MySut sut = new MySutSubClassed();
    Assertions.assertThat(sut.doSomething()).isTrue();
  }

  @Test
  void should_mock_collaborator_created_inside_method_2() { //spy
    collaborator = mock(MyCollaborator.class);
    when(collaborator.getState()).thenReturn(true);
    MySut sut = spy(new MySut());
    doReturn(collaborator).when(sut).createCollaborator();
    Assertions.assertThat(sut.doSomething()).isTrue();
  }
}
