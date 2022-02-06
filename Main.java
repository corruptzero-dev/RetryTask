package ru.corruptzero;

public class Main {

    public static void main(String[] args) {
        Retry<Query> op = new Retry<>(
                new Query(1),
                5,
                1000
        );
    }
}



