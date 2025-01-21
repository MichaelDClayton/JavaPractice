package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest extends Thread {
    private final Lock myLock = new ReentrantLock();
    private int seats = 100;

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread one = new Thread(reentrantLockTest, "One::");
        Thread two = new Thread(reentrantLockTest, "Two::");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        while (seats != 0) {
            myLock.lock();

           try{
               if (seats > 0) {
                   try {
                       Thread.sleep(50);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);

                   }
                   seats--;
                   System.out.println(Thread.currentThread().getName()+" seats left: "+seats);

               }
           }finally {
               myLock.unlock();
           }

        }
    }
}


