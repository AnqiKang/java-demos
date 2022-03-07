package multithreading;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandling {
    public static void main(String[] args) {
        boolean error = false;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                () -> {
                    if (error) {
                        throw new RuntimeException("Error@Future");
                    }
                    return "Success";

                }
        ).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return "null";
        });
        System.out.println(future.join());
    }
}
