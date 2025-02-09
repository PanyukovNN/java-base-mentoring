package ru.panyukovnn.javabasementoring.annotation;

public class AnnotationService {

    @LogExecutionTime(methodName = "Демонстрационный метод")
    public void doSomething() {
        // ...
    }
}
