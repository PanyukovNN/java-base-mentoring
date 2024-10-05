package ru.panyukovnn.javabasementoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasicsTest {

    /**
     * Конвенция имен в Java:
     * https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html
     */

    @Test
    void conditions() {
        String autumnMonth = "October";

        if (autumnMonth.equals("September")) {
            System.out.println("Первый месяц осени");
        } else if (autumnMonth.equals("October")) {
            System.out.println("Второй месяц осени");
        } else if (autumnMonth.equals("November")) {
            System.out.println("Третий месяц осени");
        } else {
            System.out.println("Месяц не определен");
        }
    }

    @Test
    void switchExample() {
        // можно использовать с типами byte, short, int, char, String, enum
        String autumnMonth = "October";

        switch (autumnMonth) {
            case "September":
                System.out.println("Первый месяц осени");
                break;
            case "October":
                System.out.println("Второй месяц осени");
                break;
            case "November":
                System.out.println("Третий месяц осени");
                break;
            default:
                System.out.println("Месяц не определен");
        }

        // В Java 12 и в Java 17 switch улучшили
        switch ("April") {
            case "December", "January", "February"      -> System.out.println("Зима");
            case "March", "April", "May"                -> System.out.println("Весна");
            case "June", "July", "August"               -> System.out.println("Лето");
            case "September", "October", "November"     -> System.out.println("Осень");
            default                                     -> System.out.println("Не удалось определить время года");
        }

        String currencySymbol = switch ("USD") {
            case "RUB"  -> "₽";
            case "USD"  -> "$";
            case "CNY"  -> "¥";
            default     -> {
                System.out.println("Не удалось определить валюту");

                yield "unknown";
            }
        };

        System.out.println(currencySymbol);
    }

    @Test
    void cycles() {
        while (true) {
            break;
        }

        do {
            break;
        } while (true);

        int i = 0;
        for (;i < 10;) {
            i++;
            break;
        }

        List<Integer> ints = List.of(1, 2, 3);
        for (Integer val : ints) {
            System.out.println(val);
        }

        Set<Integer> intSet = Set.of(1);
        System.out.println(intSet.iterator().next());
    }

    @Test
    void linkOrValue() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        printList(list);

        System.out.println(list);
//        System.out.println(i);
    }

    public void printList(List<Integer> list) {
        System.out.println(list);

        list.add(2);
    }

    public String convertToString(Integer arg1) throws Exception {
        arg1 = 1;

        if (arg1 == null) {
            throw new Exception();
        }

        return String.valueOf(arg1);
    }
}
