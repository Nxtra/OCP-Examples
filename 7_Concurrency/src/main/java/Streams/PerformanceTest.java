package Streams;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PerformanceTest {

    long process(long i){
        return Math.round(Math.hypot(new Double(i), new Double(++i)));
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Long> list = LongStream.iterate(0, i -> random.nextInt(10))
                .limit(1000000)
                .boxed()
                .collect(Collectors.toList());
        PerformanceTest performanceTest = new PerformanceTest();

        long start = Instant.now().toEpochMilli();

//        long sum = list.stream()
        long sum = list.parallelStream()
                .map(performanceTest::process)
                .mapToLong(i -> i)
                .sum();

        long stop = Instant.now().toEpochMilli();
        long timeElapsed = (stop - start);

        System.out.println("Sum: " + sum + " calculated in: " + timeElapsed + " ms");
    }
}
