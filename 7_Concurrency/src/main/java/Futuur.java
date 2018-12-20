import java.time.temporal.ChronoUnit;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Futuur {

    static int count = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<?> result = executorService.submit(() -> {
                count = IntStream.rangeClosed(0, 1000000).sum();

            });
            // get will return the result of the Runnable method
            // run() returns void, so the get() method returns null
            result.get(1, TimeUnit.SECONDS);

            System.out.println("Reached end of try block");
            System.out.println("Count is " + count);
        } catch (TimeoutException e) {
            System.out.println("Execution timed out");
        } finally {
            if (executorService != null) {
                System.out.println("Shutting down service");
                executorService.shutdown();
            }
        }
    }
}
