import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Executor1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.println("Start");

            executorService.execute(() -> System.out.println("Executing first task"));
            executorService.execute(() -> {
                System.out.println("Executing next task");
                int sum = IntStream.rangeClosed(0, 10).sum();
                System.out.println("Result: " + sum);
            });
        } finally {
            if(executorService != null){
                executorService.shutdown();
            }
        }
    }
}
