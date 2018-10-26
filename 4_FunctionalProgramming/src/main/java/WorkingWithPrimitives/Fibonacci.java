package WorkingWithPrimitives;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class Fibonacci {

    public static void main(String[] args) {
        LongSupplier fib = new LongSupplier() {
            private long preceding = 0;
            private long present = 1;

            public long getAsLong() {
                long next = preceding + present;
                preceding = present;
                present = next;
                return preceding;
            }
        };

        LongStream.generate(fib).limit(90).forEach(System.out::println);
    }

}