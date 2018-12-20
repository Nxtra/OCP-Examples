import java.util.stream.IntStream;

public class ThreadChecker {
    private static int count;

    public static void main(String[] args) {
        new Thread(() -> {
            IntStream.iterate(0, i -> i++).limit(500).forEach((i) -> count++);
        }).start();

        while(count < 500){
            System.out.println("Didn't reach end yet. Current value: " + count);
        }

        System.out.println("Yeej, reached target");
    }
}
