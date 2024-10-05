package ru.panyukovnn.javabasementoring.classes;

import org.junit.jupiter.api.Test;

public class ClassesRunner {

    @Test
    void run() {
        UserDto john1 = new UserDto("John", 20);
        UserDto john2 = new UserDto("John", 21);

        System.out.println(john1.equals(john2));

        System.out.println(john1);
    }
}
