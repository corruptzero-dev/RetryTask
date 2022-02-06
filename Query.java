package ru.corruptzero;

import java.util.Random;

public record Query(int id) implements Retryable {

    @Override
    public void request() throws InterruptedException {
        Random random = new Random();
        boolean isSuccessful = random.nextBoolean();
        if (!isSuccessful) {
            throw new Error("self error");
        }
        System.out.println("waiting...");
        Thread.sleep(random.nextLong(50L,150L));
    }
}
