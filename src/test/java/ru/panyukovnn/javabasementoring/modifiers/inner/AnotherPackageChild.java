package ru.panyukovnn.javabasementoring.modifiers.inner;

import org.junit.jupiter.api.Test;
import ru.panyukovnn.javabasementoring.modifiers.AccessModifierTest;

public class AnotherPackageChild extends AccessModifierTest {

    @Test
    void protectedExample() {
        System.out.println(this.publicField);
        System.out.println(this.protectedField);
    }
}
