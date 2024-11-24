package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueProducerConsumer {


    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Thread producer = new Thread(() -> {

               try{
                   for (int i = 1; i <= 20; i++) {
                       queue.put(i);
                       System.out.println("Task produced " + i + ".");
                       Thread.sleep(100);
                   }
               }catch (InterruptedException ie){
                   throw new RuntimeException(ie);
               }



        });

        Thread consumerOne = new Thread(() -> {
            while (true) {
                try {
                    performTask(queue.take(), "consumerOne");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerTwo = new Thread(() -> {
            while (true) {
                try {
                    performTask(queue.take(), "consumerTwo");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumerOne.start();
        consumerTwo.start();
    }


    private static void performTask(Integer taskId, String consumerName){

        try {
            System.out.println("Task "+taskId+" getting consumed by "+consumerName);
            Thread.sleep(500);
            System.out.println("Task consumed by "+consumerName+" : "+taskId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
