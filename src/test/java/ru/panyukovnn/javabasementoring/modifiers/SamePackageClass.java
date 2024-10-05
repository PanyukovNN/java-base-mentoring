package ru.panyukovnn.javabasementoring.modifiers;

import org.junit.jupiter.api.Test;

public class SamePackageClass {

    @Test
    void protectedExample() {
        AccessModifierTest accessModifierTest = new AccessModifierTest();

        System.out.println(accessModifierTest.publicField);
        System.out.println(accessModifierTest.protectedField);
        System.out.println(accessModifierTest.packagePrivateField);
    }
}
