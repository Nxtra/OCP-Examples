package WorkingWithPrimitives;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class UsingPrimitives {

    public static void main(String[] args) {
        getAverageOfIntRange(0,100).ifPresent(System.out::println);

        print(getBottomTopDifference(new Random().ints(10, 0, 100)));
    }

    private static OptionalDouble getAverageOfIntRange(int start, int stop){
        return IntStream.rangeClosed(start, stop).average();
    }

    private static int getBottomTopDifference(IntStream ints){
        IntSummaryStatistics stats = ints.summaryStatistics();
        return stats.getMax() - stats.getMin();
    }

    private static void print(Object resource){
        System.out.println(resource);
    }
}