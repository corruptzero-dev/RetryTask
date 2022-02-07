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
        RetryThread tt2 = new RetryThread();
        while (true){
            try {
                if(this.attempts<=maxAttempts){
                    clazz.request();
                } else {
                    System.out.println("out of attempts, halt.");
                    break;
                }
                System.out.println("Success!");
                break;
            } catch (Error | InterruptedException someError){
                System.out.printf("Retry! (%s)\n", someError.getMessage());
                attempts++;
            }
        }
    }

}
