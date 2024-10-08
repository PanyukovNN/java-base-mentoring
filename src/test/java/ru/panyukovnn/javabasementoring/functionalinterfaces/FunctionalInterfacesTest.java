package ru.panyukovnn.javabasementoring.functionalinterfaces;

import org.junit.jupiter.api.Test;
import ru.panyukovnn.javabasementoring.mapexample.UserFeedback;

import java.util.Comparator;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalInterfacesTest {

    @Test
    void predicate() {
        Predicate<Integer> filterLower2015 = new Predicate<>() {
            @Override
            public boolean test(Integer year) {
                return year < 2015;
            }
        };

        assertTrue(filterLower2015.test(2014));

        Predicate<Integer> filterHigher2015 = year -> year > 2015;

        passPredicateInArgument(2016, filterHigher2015);
        passPredicateInArgument(2018, year -> year > 2020);
    }

    private void passPredicateInArgument(Integer value, Predicate<Integer> predicate) {
        if (predicate.test(value)) {
            System.out.println("Значение соответствует предикату: " + value);

            return;
        }

        System.out.println("Значение не соответствует предикату: " + value);
    }

    @Test
    void consumer() {
        Consumer<String> printValue = str -> System.out.println(str);

        printValue.accept("Выведено на печать через Consumer");
    }

    @Test
    void supplier() {
        Supplier<String> fabric = () -> "new object";

        System.out.println(fabric.get());
    }

    @Test
    void function() {
        Function<Integer, Integer> addTen = i -> i + 10;

        System.out.println(addTen.apply(1));
    }

    @Test
    void biFunction() {
        BiFunction<Integer, Integer, Integer> max = (i1, i2) -> i1 >= i2 ? i1 : i2;

        System.out.println(max.apply(10, 5));
    }

    @Test
    void unaryOperator() {
        UnaryOperator<String> multiplyString = str -> str.repeat(5);

        System.out.println(multiplyString.apply("Hello"));
    }

    @Test
    void binaryOperator() {
        UserFeedback userFeedback1 = new UserFeedback("id1", 5, "Хорошо");
        UserFeedback userFeedback2 = new UserFeedback("id2", 4, "Средне");

        BinaryOperator<UserFeedback> maxBy = BinaryOperator.maxBy(Comparator.comparing(UserFeedback::getRating));

        System.out.println(maxBy.apply(userFeedback1, userFeedback2));
    }

    @Test
    void ownFunctionalInterface() {
        ThreeFunction<Integer, Integer, Integer, Integer> threeFunction = (i1, i2, i3) -> i1 + i2 + i3;

        Integer result = threeFunction.apply(1, 2, 3);

        System.out.println(result);
        assertEquals(6, result);
    }

}
