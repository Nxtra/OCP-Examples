import java.util.Random;

class T1 implements Runnable {

    Random random = new Random();

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from T1 " + i);
            try {
                int sleep = random.nextInt(100);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 extends Thread {

    Random random = new Random();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from T2: " + i);
            try {
                int sleep = random.nextInt(100);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("Start");

        Thread th1 = new Thread(new T1());
        T2 th2 = new T2();

        th1.start();
        th2.start();

        System.out.println("Stop");
    }
}
