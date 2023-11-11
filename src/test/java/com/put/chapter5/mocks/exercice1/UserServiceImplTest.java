package com.put.chapter5.mocks.exercice1;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  UserDao userDao;

  @Mock
  User user;

  @Mock
  SecurityService securityService;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  void should_update_user_password() {
    String password = "password";
    when(user.getPassword()).thenReturn(password);
    String passwordMd5 = "passwordMd5";
    when(securityService.md5(password)).thenReturn(passwordMd5);

    userService.assignPassword(user);

    verify(user).setPassword(passwordMd5);
    verify(userDao).updateUser(user);
  }
}
