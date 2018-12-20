import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FutuurCallableSleep {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count = 0;
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(2);
            Future<Integer> result = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": Counting..");
                TimeUnit.SECONDS.sleep(1);
                int value = IntStream.rangeClosed(0, 1000000).sum();
                System.out.println(Thread.currentThread().getName() + ": Counted: " + value);
                return value;
            });
            executorService.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ": Sleeping..");
                }
                return null;
            });
            count = result.get();

            System.out.println("Reached end of try block");
            System.out.println(Thread.currentThread().getName() + ": Count is " + count);
        }
        finally {
            if (executorService != null) {
                System.out.println("Shutting down service");
                // Executor will wait to terminate till all running threads are finished
                executorService.shutdown();
            }
        }
        if (executorService != null) {
            while (!executorService.isTerminated()) {
                System.out.println("Still tasks running");
                executorService.awaitTermination(1, TimeUnit.SECONDS);
            }
            System.out.println("All tasks done");
        }
    }
}
