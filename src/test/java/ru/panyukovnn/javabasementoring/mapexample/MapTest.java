package ru.panyukovnn.javabasementoring.mapexample;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    void map() {
        Map<String, String> map = new HashMap<>();

        map.put("Candy", "Shop");

        System.out.println(map.get("Candy"));

        map.put("Candy", "Box");

        System.out.println(map.get("Candy"));
    }

    @Test
    void sameKeyHashcode() {
        Map<UserFeedback, Product> userFeedbackMap = new HashMap<>();

        userFeedbackMap.put(
            new UserFeedback("id1", 5, "Хороший телефон"),
            new Product("iphone 10")
        );

        userFeedbackMap.put(
            new UserFeedback("id1", 1, "Так себе телефон"),
            new Product("iphone 11")
        );

        System.out.println(userFeedbackMap);
        assertEquals(1, userFeedbackMap.size());
    }

    @Test
    void lostValue() {
        Map<UserFeedback, Product> userFeedbackMap = new HashMap<>();

        UserFeedback feedback = new UserFeedback("id1", 5, "Хороший телефон");
        userFeedbackMap.put(feedback, new Product("iphone 10"));

        feedback.setId("newId");

        System.out.println(userFeedbackMap.get(feedback));
        assertNull(userFeedbackMap.get(feedback));
    }

    @Test
    void nulls() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "it' value with null key");

        System.out.println(map);
        assertEquals(1, map.size());

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null, "it' value with null key");

        System.out.println(linkedHashMap);
        assertEquals(1, linkedHashMap.size());

        Map<String, String> treeMap = new TreeMap<>();
        assertThrows(
            NullPointerException.class,
            () -> treeMap.put(null, "it' value with null key")
        );
        System.out.println(treeMap);
    }

    @Test
    void sameHashCodeDifferentEquals() {
        Map<SameHashCodeObjects, String> map = Map.of(
            new SameHashCodeObjects(UUID.randomUUID()), "value1",
            new SameHashCodeObjects(UUID.randomUUID()), "value2"
        );

        System.out.println(map);
        assertEquals(2, map.size());
    }

    @Test
    void setTest() {
        Set<String> set = new HashSet<>();

        set.add("Candy");

        System.out.println(set.contains("Candy"));

        set.add("Candy");

        System.out.println(set);
        assertEquals(1, set.size());
    }
}
