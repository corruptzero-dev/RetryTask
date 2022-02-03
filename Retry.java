package ru.corruptzero;


public class Retry <T extends Retryable> {
    T clazz;
    int attempts = 0;
    int maxAttempts;
    long ms;

    public Retry(T clazz, int maxAttempts, int ms) {
        this.clazz = clazz;
        this.maxAttempts = maxAttempts;
        this.ms = ms;
        while (true){
            try {
                long time;
                if(this.attempts<=maxAttempts){
                    time = System.currentTimeMillis();
                    clazz.request();
                    if((System.currentTimeMillis() - time)>ms){
                        throw new Error("long response time");
                    }
                } else {
                    System.out.println("out of attempts, halt.");
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
