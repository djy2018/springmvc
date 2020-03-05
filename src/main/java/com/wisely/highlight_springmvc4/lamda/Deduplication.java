package com.wisely.highlight_springmvc4.lamda;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author dujiayong
 * @date 2019/07/19
 **/
public class Deduplication {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Book sun_java = new Book(11, "Java");
        Book oracle_java = new Book(12, "Java");
        Book scala = new Book(15, "Scala");
        books.add(sun_java);
        books.add(oracle_java);
        books.add(scala);

        List<Object> collect = books.stream().distinct().collect(Collectors.toList());

//        List<Object> collect = new ArrayList<>(new HashSet<>(books));

        List<Book> unique = books.stream().collect(
                collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.id))),
                        ArrayList::new));

    }

    static class Book {

        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Book(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(getId(), book.getId()) &&
                    Objects.equals(getName(), book.getName());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getId(), getName());
        }
    }
}
