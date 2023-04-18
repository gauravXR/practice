public class PrintEvenOdd {

    private static final int MAX = 10;

    private volatile int count = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {

        PrintEvenOdd obj = new PrintEvenOdd();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (obj.count < MAX) {
                    synchronized (obj.lock) {
                        while (obj.count % 2 == 0) {
                            try {
                                obj.lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread 1: " + obj.count);
                        obj.count++;
                        obj.lock.notifyAll();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (obj.count < MAX) {
                    synchronized (obj.lock) {
                        while (obj.count % 2 != 0) {
                            try {
                                obj.lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread 2: " + obj.count);
                        obj.count++;
                        obj.lock.notifyAll();
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }

}
