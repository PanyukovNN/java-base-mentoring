package ru.panyukovnn.javabasementoring.solid;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SolidTest {

    @Test
    void liskov() {
        List<String> list = Collections.unmodifiableList(new LinkedList<>());

        process(list);
    }

    private void process(List<String> list) {
        list.add("S");
        list.add("O");
        list.add("L");
        list.add("I");
        list.add("D");

        list.forEach(System.out::println);
    }
}
