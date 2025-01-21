package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Thread one = new Thread(new MyConsumer(semaphore, "Thread 1", 2000));
        one.start();

        Thread two = new Thread(new MyConsumer(semaphore, "Thread 2", 0));
        two.start();
        System.out.println();

    }
}

class MyConsumer implements Runnable{
    private final Semaphore semaphore;
    private final String threadName;
    private final long sleepTime;

    public MyConsumer(Semaphore semaphore, String threadName, long sleepTime) {
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run(){
        System.out.println(this.threadName+" is attempting to get permit from semaphore.");
        try {
            this.semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Permit acquired by "+this.threadName);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.threadName+" is releasing semaphore.");
        semaphore.release();
    }
}