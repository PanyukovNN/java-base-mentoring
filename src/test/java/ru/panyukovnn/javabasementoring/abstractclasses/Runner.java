package ru.panyukovnn.javabasementoring.abstractclasses;

import org.junit.jupiter.api.Test;

import static ru.panyukovnn.javabasementoring.constants.Constants.LANG_RU;

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
