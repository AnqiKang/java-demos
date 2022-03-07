package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineEx {
    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<String> getUserEmail() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserEmail() - " + Thread.currentThread().getName());
            delay(3);
            return "karen@gmail.com";
        });
    }

    private static CompletableFuture<String> getWeatherReport() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getWeatherReport() - " + Thread.currentThread().getName());
            delay(3);
            return " Weather Report of city is - Denver";
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future = getUserEmail().thenCombine(getWeatherReport(), (e, w) -> {
            System.out.println("Sending email to " + e + " with report - " + w);
            delay(1);
            return e + w;
        });
        System.out.println("Do sth in main! ");
        delay(3);
        System.out.println(future.join());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + (endTime - startTime) / 1000);
    }

}
