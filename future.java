import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(5000);
            return 123;
        });

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");
        int result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}
