package ru.panyukovnn.javabasementoring.enumexample;

public enum Currencies {

    RUB("₽", () -> {}),
    USD("$", () -> {}),
    CNY("¥", () -> {});

    private final String symbol;
    private final Runnable runnable;

    Currencies(String symbol, Runnable runnable) {
        this.symbol = symbol;
        this.runnable = runnable;
    }
}
