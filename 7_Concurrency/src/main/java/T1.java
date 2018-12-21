class Main{
    public static void main(String[] args) {
        System.out.println("Begin");

        Thread th1 = new Thread(new T1());
        Thread th2 = new T2();

        th1.start();
        th2.start();

        System.out.println("End");
    }
}

class T1 implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello from T1 " + i);
        }
    }
}

class T2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello from T2: " + i);
        }
    }
}

