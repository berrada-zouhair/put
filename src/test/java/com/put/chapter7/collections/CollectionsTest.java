package com.put.chapter7.collections;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import com.put.chapter6.custom.assertions.Book;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

public class CollectionsTest {

  @Test
  void set_should_contain_only_two_elements() {
    TreeSet<String> set = Sets.newTreeSet("e1", "e2");
    assertThat(set).containsOnly("e1", "e2");
  }

  @Test
  void map_should_contain_only_two_entries() {
    HashMap<String, String> map = new HashMap<String, String>() {{
      put("entry1", "value1");
      put("entry2", "value2");
    }};
    assertThat(map).containsOnly(entry("entry1", "value1"), entry("entry2", "value2"));
    assertThat(map).doesNotContain(entry("entry3", "value3"));
  }

  @Test
  void should_extract_name_from_book_collection() {
    Collection<Book> books = Arrays.asList(
        new Book("PUT", "English", 200),
        new Book("Zero to one", "English", 100),
        new Book("On m'avait dit que c'était impossible", "French", 90)
    );
    Collection<Book> filtredBooks = books.stream()
        .filter(book -> book.getPages() <= 100)
        .collect(toList());
    assertThat(filtredBooks)
        .extracting(Book::getTitle)
        .containsOnly("Zero to one", "On m'avait dit que c'était impossible");
  }
}
