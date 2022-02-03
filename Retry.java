package ru.corruptzero;


public class Retry <T extends Retryable> {
    T clazz;
    int attempts = 0;
    int maxAttempts;
    int ms;

    public Retry(T clazz, int maxAttempts, int ms) {
        this.clazz = clazz;
        this.maxAttempts = maxAttempts;
        this.ms = ms;
        while (true){
            try {
                if(this.attempts<=maxAttempts){
                    clazz.request();
                } else {
                    System.out.println("out of attempts, halt.");
                }
                System.out.println("Success!");
                break;
            } catch (Error someError){
                System.out.println("Retry!");
                attempts++;
            }
        }
    }

}
