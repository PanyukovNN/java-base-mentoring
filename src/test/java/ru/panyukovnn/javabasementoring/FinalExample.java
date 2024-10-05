package ru.panyukovnn.javabasementoring;

import org.junit.jupiter.api.Test;

public final class FinalExample {

    private final String name = "John";

    public final String multiply(final Integer multiplier) {
        final String result = name.repeat(multiplier);

        return result;
    }

    @Test
    void run() {
        System.out.println(multiply(5));
    }

}
