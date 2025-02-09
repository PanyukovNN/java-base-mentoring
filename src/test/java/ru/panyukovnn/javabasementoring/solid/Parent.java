package ru.panyukovnn.javabasementoring.solid;

import java.io.IOException;

public class Parent {

    protected void doSomething() throws IOException {
        throw new IOException();
    }
}
