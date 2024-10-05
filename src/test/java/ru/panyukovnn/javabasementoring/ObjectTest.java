package ru.panyukovnn.javabasementoring;

import org.junit.jupiter.api.Test;

public class ObjectTest {

    @Test
    void objectMethods() {
//        object.getClass();
//        object.equals(...);
//        object.hashCode();
//        object.toString();

//        object.wait(); - устаревший механизм ожидания через внутренние очереди
//        object.notify();
//        object.notifyAll();

//        object.clone(); - нужно реализовать интерфейс Cloneable
//        object.finalize(); - никогда не использовать
    }

    @Test
    void arrays() {
        int[] ints = {1};

        long[] longs = new long[5]; // [0, 0, 0, 0, 0]

//        int[] tooHeavyArray = new int[Integer.MAX_VALUE];

        String[] strings = {"abc", "def"};

        // Важно! В массивах все элементы лежат рядом друг с другом в памяти
    }

    volatile boolean flag;

    @Test
    void waitNotify() throws InterruptedException {
        Object object = new Object();

        new Thread(() -> {
            System.out.println("thread 1 start");

            while (!flag) {
                synchronized (object) {
                    try {
                        System.out.println("thread 1 wait");
                        object.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            System.out.println("thread 1 finish");
        }).start();

        Thread.sleep(500);

        new Thread(() -> {
            System.out.println("thread 2 start");

            synchronized (object) {
                System.out.println("thread 2 release thread 1 wait");
                flag = true;
                object.notify();
            }

            System.out.println("thread 2 finish");
        }).start();

        Thread.sleep(1000);
    }
}
