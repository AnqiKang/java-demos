package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ComposeEx {
    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserDetails() " + Thread.currentThread().getName());
            delay(2);
            return "UserDetails";
        });
    }

    private static CompletableFuture<String> getWishList(String user) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("getWishList() " + user + " - " + Thread.currentThread().getName());
//            delay(3);
//            return "User's WishList";
//        });
        Supplier<String> stringSupplier = () -> {
            System.out.println("getWishList() " + user + " - " + Thread.currentThread().getName());
            delay(3);
            return "User's WishList";
        };
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(stringSupplier);
        return completableFuture;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future = getUserDetails().thenCompose(s -> {
            return getWishList(s);
        });
        System.out.println("Doing sth");
        delay(4);
        System.out.println(future.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + (endTime - startTime) / 1000);
    }
}
