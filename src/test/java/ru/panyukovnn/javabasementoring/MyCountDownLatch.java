package ru.panyukovnn.javabasementoring;

public class MyCountDownLatch {

    private volatile boolean release = false;
    private final Object lock = new Object();

    public void lock() {
        synchronized (lock) {
            try {
                while (!release) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        release = false;
    }

    public void release() {
        synchronized (lock) {
            lock.notifyAll();
            release = true;
        }
    }
}
