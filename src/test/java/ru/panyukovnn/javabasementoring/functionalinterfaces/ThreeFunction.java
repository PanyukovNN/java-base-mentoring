package ru.panyukovnn.javabasementoring.functionalinterfaces;

@FunctionalInterface // информационная аннотация
public interface ThreeFunction<Arg1, Arg2, Arg3, Result> {

    Result apply(Arg1 arg1, Arg2 arg2, Arg3 arg3);

    default void doSmth() {
    };

    private void doSmthNew() {
    }

}
