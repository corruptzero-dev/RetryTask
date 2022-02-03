package ru.corruptzero;

import java.util.Random;

public record Query(int id) implements Retryable {

    @Override
    public void request() {
        Random random = new Random();
        boolean isSuccessful = random.nextBoolean();
        if (!isSuccessful) {
            throw new Error("Error");
        }
    }

//    public int getId() {
//        return id;
//    }
}
