package ru.corruptzero;

public class RetryThread extends Thread {
    @Override
    public void run() {
        Retry<Query> op = new Retry<>(
                new Query(1),
                5,
                1000
        );
    }
}
