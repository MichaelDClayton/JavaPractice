package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args){
        Worker worker = new Worker(5, 0);
        Thread producer = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer 1");

        Thread consumer2 = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Consumer 2");

        producer.start();
        consumer.start();
        consumer2.start();
    }


}


class Worker {
    private int sequence = 0;
    private final Integer max;
    private final Integer min;
    private List<Integer> queue;
    private final Object lock = new Object();

    public Worker(Integer max, Integer min) {
        this.max = max;
        this.min = min;
        this.queue = new ArrayList<>();
    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (queue.size() == max) {
                    System.out.println("Queue is full, waiting for items to be consumed...");
                    lock.wait();
                } else {
                    System.out.println(sequence + " Added to the queue");
                    queue.add(sequence++);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (queue.size() == min) {
                    System.out.println("Waiting for items to be added to queue");
                    lock.wait();
                } else {
                    System.out.println(queue.removeFirst() + " removed from the queue");
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}