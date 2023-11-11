package com.put.chapter8.privat.methods;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

public class PrivateMethodReflectionTest {


  @Test
  void should_test_private_method_with_reflection()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    SomeClass someClass = new SomeClass();

    Class[] parameterTypes = new Class[1];
    parameterTypes[0] = Long.class;

    Method m = someClass.getClass().getDeclaredMethod("privateMethod", parameterTypes);
    m.setAccessible(true);

    Object[] parameters = new Object[1];
    parameters[0] = 123L;

    boolean result = (boolean) m.invoke(someClass, parameters);
    assertThat(result).isTrue();
  }

  @Test
  void should_test_private_method_with_reflection_utils()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    SomeClass someClass = new SomeClass();
    Method method = someClass.getClass().getDeclaredMethod("privateMethod", Long.class);
    ReflectionUtils.makeAccessible(method);
    assertThat((boolean) method.invoke(someClass, 123L)).isTrue();
  }

  @Test
  void package_access_methods_could_be_accessed_in_tests() {
    SomeClass someClass = new SomeClass();
    assertThat(someClass.privateMethod(123L)).isTrue();
  }
}
