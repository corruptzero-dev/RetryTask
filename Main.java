package ru.corruptzero;

public class Main {

    public static void main(String[] args) {
        final var op = new Retry<Query>(
                new Query(1),
                5,
                1000
                );

    }
}
