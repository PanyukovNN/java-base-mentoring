package ru.panyukovnn.javabasementoring.unmodifiablecollections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnmodifiableCollections {

    private List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

    private Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

    private Map<Integer, String> unmodifiableMap = Map.of(
        1, "a",
        2, "b",
        3, "c",
        4, "d",
        5, "e",
        6, "f",
        7, "g",
        8, "h",
        9, "i",
        10, "g"
    );
    private Map<Integer, String> unmodifiableMapOfEntries = Map.ofEntries(
        Map.entry(1, "a"),
        Map.entry(2, "b"),
        Map.entry(3, "c"),
        Map.entry(4, "d"),
        Map.entry(5, "e"),
        Map.entry(6, "f"),
        Map.entry(7, "g"),
        Map.entry(8, "h"),
        Map.entry(9, "i"),
        Map.entry(10, "g"),
        Map.entry(11, "h")
    );

    @Test
    void makeUnmodifiableList() {
        List<String> list = new ArrayList<>();
        list.add("a");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        List<String> unmodifiableList2 = List.copyOf(list);

        Set<String> set = new HashSet<>();
        set.add("a");

        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
        Set<String> unmodifiableSet2 = Set.copyOf(set);

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
        Map<String, String> unmodifiableMap2 = Map.copyOf(map);
    }

    @Test
    void streamUnmodifiableCollectors() {
        List<BaseEntity> list = new ArrayList<>();
        list.add(new BaseEntity(UUID.randomUUID()));
        list.add(new BaseEntity(UUID.randomUUID()));

        List<BaseEntity> unmodifiableList = list.stream()
            .collect(Collectors.toUnmodifiableList());

        Set<BaseEntity> unmodifiableSet = list.stream()
            .collect(Collectors.toUnmodifiableSet());

        Map<UUID, BaseEntity> unmodifiableMap = list.stream()
            .collect(Collectors.toUnmodifiableMap(baseEntity -> baseEntity.id, baseEntity -> baseEntity));
    }

    private record BaseEntity(UUID id) {
    }
}
