package ru.panyukovnn.javabasementoring.solid;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class Child extends Parent {

    @Override
    public void doSomething() throws AccessDeniedException {
        try {
            super.doSomething();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
