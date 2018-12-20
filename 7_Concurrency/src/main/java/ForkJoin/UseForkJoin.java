package ForkJoin;

import util.StopWatch;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class UseForkJoin {

    public static void main(final String[] arguments) {
        StopWatch stopWatch = new StopWatch();

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of threads: " + numberOfThreads);

        int[] numbers = new int[200];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        stopWatch.start();

        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        Long result = forkJoinPool.invoke(new CalculationTask(numbers,0, numbers.length));
        System.out.println("sum is: " + result);

        stopWatch.stop();
        System.out.println("This took: " + stopWatch.getDiff() + " ms");
    }

    // RecursiveTask represents a task which returns a value.
    // RecursiveAction represents a task which does not return any value.
    static class CalculationTask extends RecursiveTask<Long> {
        int low;
        int high;
        int array[];

        CalculationTask(int array[], int low, int high) {
            this.array = array;
            this.low   = low;
            this.high  = high;
        }

        protected Long compute() {

            if(high - low <= 25) {
                System.out.println(Thread.currentThread().toString() + ": high: " + high + ", low: " + low);
                long sum = 0;

                for(int i = low; i < high; ++i)
                    sum += array[i];
                return sum;
            } else {
                System.out.println(Thread.currentThread().toString() + ": high: " + high + ", low: " + low);
                int mid = low + (high - low) / 2;
                CalculationTask leftPart  = new CalculationTask(array, low, mid);
                CalculationTask rightPart = new CalculationTask(array, mid, high);
                // fork() splits into subtasks
                // pushes it on the dequeue of the current thread
                // other threads do "workstealing" and steal a task from the back of the current Threads dequeue
                // According to this thread-1 will always execute the smallest right subtask
                leftPart.fork();
                // current thread goes further to compute right
                long rightResult = rightPart.compute();
                // join the result of all the subtasks
                long leftResult  = leftPart.join();
                return leftResult + rightResult;
            }
        }
    }
}