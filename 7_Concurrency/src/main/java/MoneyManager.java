import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoneyManager {

    private int moneyCount;

    //    private void getPayCheck(){
    private synchronized void getPayCheck() {
        moneyCount += 1500;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(moneyCount));
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        try {
            MoneyManager moneyManager = new MoneyManager();
            for (int i = 0; i < 24; i++) {
                executorService.submit(moneyManager::getPayCheck);
            }
        } finally {
            System.out.println("Shutting  down");
            executorService.shutdown();
            System.out.println("Started shutdown");
        }

    }
}
