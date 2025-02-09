package ru.panyukovnn.javabasementoring;

import java.util.ArrayList;
import java.util.List;

public class MyObject implements Cloneable {

    private int i = 1;
    private List<String> list = new ArrayList<>();

    public MyObject clone() throws CloneNotSupportedException {
        return (MyObject) super.clone();
    }
}
