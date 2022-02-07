package ru.corruptzero;

public class Main {

    public static void main(String[] args) {
        try {
            RetryThread t = new RetryThread();
            t.start();
            Thread.sleep(1000);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e){
            System.out.println("long response time");
        }
    }
}



