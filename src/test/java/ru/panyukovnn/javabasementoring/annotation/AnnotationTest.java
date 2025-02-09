package ru.panyukovnn.javabasementoring.annotation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest {

    @Test
    void annotation() {
        Method[] methods = AnnotationService.class.getMethods();

        Arrays.stream(methods)
            .filter(method -> method.getAnnotation(LogExecutionTime.class) != null)
            .forEach(method -> {
                System.out.println(method.getAnnotation(LogExecutionTime.class).methodName());
                System.out.println(method.getName());
            });
    }
}
