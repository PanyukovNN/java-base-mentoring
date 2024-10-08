package ru.panyukovnn.javabasementoring.generics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericsTest {

    @Test
    void generics() {
        // Дженерики инвариантны
        List<Integer> ints = List.of(1);
//        genericsInvariant(ints); // Не сработает
        inheritedGenerics(ints);

        // Массивы ковариантны
        Integer[] intsArray = {1};
        arraysCovariant(intsArray);

        wildcard(List.of("abc", "def"));
        wildcard(List.of(1, 2, 3));

//        Нельзя создать объект класса дженерика
//        Нельзя использовать примитивные типы
//        Нельзя использовать в статических полях
    }

    void genericsInvariant(List<Number> nums) {
    }

    void inheritedGenerics(List<? extends Number> nums) {
    }

    void arraysCovariant(Number[] nums) {
    }

    void wildcard(List<?> anyList) {
//        anyList.add(new Object()); // Запрещено
    }


    // -------------------- Type erasure -------------------------

    void methodWithSameSignature(List<Integer> ints) {

    }

//    void methodWithSameSignature(List<String> strings) {
//
//    }

    // -------------------- Method generics -------------------------

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertToObject(String rawObject, Class<T> obj) {
        try {
            return objectMapper.readValue(rawObject, obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка парсинга json", e);
        }
    }

    // -------------------- Impossible to create object -------------------------

    public <T> void impossibleToCreateNewObject() {
//        new T();
    }
}
