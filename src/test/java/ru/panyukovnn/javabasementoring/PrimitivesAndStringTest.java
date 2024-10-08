package ru.panyukovnn.javabasementoring;

import org.junit.jupiter.api.Test;

public class PrimitivesAndStringTest {

    @Test
    void weight() {
        byte b = 1; // -128 +127 - 1 байт
        short s = 1; // -32000 +32000 - 2 байта
        int i = 1; // -2147000000 +2147000000 - 4 байта
        long l = 1; // 8 байт
        float f = .0f; // 4 байта
        double d = .0; // 8 байт
        char c = 'c'; // 0 +64000 2 байта
        boolean bool; // 1 байт true/false

        Object obj = new Object(); // Вес ссылки 4 байта (если куча больше 32 Гб, то 8 байт)

        String str = "abc"; // UTF-16 2 байта - UTF-8 1 байт

        // Хитрый вопрос с собеседования:
        // Сколько будет весить объект в котором есть два поля, одна с типом boolean, другая с типом int

        // Примитивы хранятся в стеке потока
        // Объекты хранятся в памяти, а в стеке только ссылки на объекты в памяти
    }

    @Test
    void pools() {
        Integer i1 = 127; // пулы числовых оберток
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Character c1 = 127;
        Character c2 = 127;
        System.out.println(c1 == c2);

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str2.equals(str3));
    }

    @Test
    void defaultValues() {
        byte b = 0;
        short s = 0;
        int i = 0;
        long l = 0;
        float f = .0f;
        double d = .0;
        char c = 0;
        boolean bool = false;

        Object obj = null;
//        obj.toString() - NullPointerException
    }

    @Test
    void immutableStringsAndPrimitiveWrappers() {
        String s = "one";
        System.out.println(s.hashCode());
        s = s + "two";
        System.out.println(s.hashCode());

        Integer i = 1;
        System.out.println(i.hashCode());
        i += 2;
        System.out.println(i.hashCode());
    }
}
