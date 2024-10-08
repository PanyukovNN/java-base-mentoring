package ru.panyukovnn.javabasementoring.abstractclasses;

import org.junit.jupiter.api.Test;

public class Runner {

    @Test
    void run() {
        new ChildOne().process();

        System.out.println();

        new ChildTwo().process();
    }

    @Test
    void cantCreateParent() {
//        new AbstractParent();
    }
}
