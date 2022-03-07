package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallableEx {
    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    delay(2);
                    return "Karen";
                }
        ).thenApply(s -> {
            return "Hello " + s;
        }).thenRun(() ->
                System.out.println("Finished")
        );

        completableFuture.join();
    }
}
