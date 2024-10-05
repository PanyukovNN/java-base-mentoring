package ru.panyukovnn.javabasementoring.abstractclasses;

public abstract class AbstractParent {

    public void process() {
        System.out.println("Начинаю выполнятьобщую логику");

        System.out.println("Имя наследника: " + getChildName());

        System.out.println("Заканчиваю выполнятьобщую логику");
    }

    public abstract String getChildName();
}
