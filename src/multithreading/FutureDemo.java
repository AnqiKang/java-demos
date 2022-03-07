package multithreading;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            delay(1);
            return "Hello from Future";
        };
        Future<String> future = executorService.submit(callable);
        System.out.println("Doing sth else");
        delay(1);

        String message = future.get();
        System.out.println(message);
        executorService.shutdown();
    }

    private static void delay(int i) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
