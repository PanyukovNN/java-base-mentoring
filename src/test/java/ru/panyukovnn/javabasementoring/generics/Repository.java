package ru.panyukovnn.javabasementoring.generics;

import java.util.Collection;

public interface Repository<ID, T> {

    T findById(ID id);

    Collection<T> findAll();

    T save(T entity);

    void deleteById(ID id);
}
