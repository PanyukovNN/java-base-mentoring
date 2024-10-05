package ru.panyukovnn.javabasementoring.interfaces;

public interface ParentInterface {

    Integer getOrder();

    default String getName() {
        return calculateDefaultName();
    }

    private String calculateDefaultName() {
        return "Имя по умолчанию. Порядковый номер: " + getOrder();
    }
}
