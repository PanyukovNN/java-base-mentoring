package ru.panyukovnn.javabasementoring.interfaces;

public class ChildTwo implements ParentInterface {

    @Override
    public Integer getOrder() {
        return 2;
    }

    @Override
    public String getName() {
        return "Второй наследник";
    }
}
