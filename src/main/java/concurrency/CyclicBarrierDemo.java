package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int  NUM_OF_TOURISTS = 3;
    private static final int NUM_OF_STAGES = 3;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_OF_TOURISTS, ()->{
        System.out.println("All tourists have arrived, tour guide can now speak.");
    });

    public static void main(String[] args) {
        for (int i = 0; i < NUM_OF_TOURISTS; i++) {
            Thread thread = new Thread(new Tourist(i));
            thread.start();
        }
    }


static class Tourist implements Runnable{
    private final int touristId;

    public Tourist(int touristId){
        this.touristId = touristId;
    }

    @Override
    public void run(){
        for (int i = 0; i < NUM_OF_STAGES; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tourist "+ touristId + " has arrived at stage "+i);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
}