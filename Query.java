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
        Thread.sleep(random.nextLong(500L,1500L));
    }

//    public int getId() {
//        return id;
//    }
}
