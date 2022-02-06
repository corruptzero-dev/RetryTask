package ru.corruptzero;

public class TaskThread2 extends Thread {
    int ms;
    @Override
    public void run() {
        try {
            Thread.sleep(ms);
            throw new Error("long response time");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
