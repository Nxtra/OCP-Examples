import java.time.temporal.ChronoUnit;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FutuurC {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        int count = 0;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<Integer> result = executorService.submit(() -> IntStream.rangeClosed(0, 1000000).sum());
            // get will return the result of the Callable method
            // call() return Integer here, so the get() method returns Integer
            count = result.get(1, TimeUnit.SECONDS);

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
