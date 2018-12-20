package ForkJoin;

import util.StopWatch;

import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class WithoutForkJoin {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        int[] numbers = new int[200];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        stopWatch.start();

        int sum = Arrays.stream(numbers)
                .sum();

        System.out.println("CalculationTask: " + sum);

        stopWatch.stop();
        System.out.println("This took: " + stopWatch.getDiff() + "ms");
    }
}
