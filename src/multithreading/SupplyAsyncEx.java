package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsyncEx {
    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> {
            delay(1);
            System.out.println("I am in Supplier - " + Thread.currentThread().getName());
            return "Hello from Supplier";
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(stringSupplier);

        System.out.println("I am in Main - " + Thread.currentThread().getName());

        String value = completableFuture.join();
        System.out.println("Value : " + value);

    }
}
