package ConcurrentCollections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class UsingDeque {
    public static void main(String[] args) {
        try{
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(10);
            blockingDeque.offerFirst(20, 10, TimeUnit.SECONDS);
            blockingDeque.offerLast(30, 400, TimeUnit.MILLISECONDS);
            blockingDeque.offer(40, 4, TimeUnit.SECONDS);

            // prints 20, 40, 10, 30
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
            System.out.println(blockingDeque.poll(1000, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.SECONDS));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
