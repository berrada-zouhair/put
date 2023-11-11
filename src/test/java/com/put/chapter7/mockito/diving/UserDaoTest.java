package com.put.chapter7.mockito.diving;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.hamcrest.MockitoHamcrest;

public class UserDaoTest {

  @Test
  void should_get_same_user_whatever_requested_id() {
    UserDao userDao = Mockito.mock(UserDao.class);
    User user = new User();
    when(userDao.getUser(anyLong())).thenReturn(user);
    User user1 = userDao.getUser(1);
    User user2 = userDao.getUser(2);
    User user3 = userDao.getUser(3);
    Assertions.assertThat(user)
        .isEqualTo(user1)
        .isEqualTo(user2)
        .isEqualTo(user3);
    verify(userDao, times(3)).getUser(anyLong());
  }

  @Test
  void should_get_user_matching_defined_properties() {
    UserDao userDao = mock(UserDao.class);
    User user = new User();
    Map<String, String> properties = (Map<String, String>) MockitoHamcrest
        .argThat(Matchers.hasEntry("id", "2"));
    when(userDao.getByProperties(properties))
        .thenReturn(user);

    HashMap<String, String> requestedProperties = new HashMap<>();
    requestedProperties.put("id", "2");
    User requestedUser = userDao.getByProperties(requestedProperties);
    Assertions.assertThat(requestedUser).isEqualTo(user);
  }
}
