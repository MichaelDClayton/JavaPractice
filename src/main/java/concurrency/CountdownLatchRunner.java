package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchRunner{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new CountdownLatchDemo(latch, "Leo", "Pizza", 500)).start();
        new Thread(new CountdownLatchDemo(latch, "John", "Stew", 2000)).start();
        new Thread(new CountdownLatchDemo(latch, "Bobby", "BBQ Chicken", 1000)).start();

        latch.await();
        System.out.println("Food is ready!");


    }
}

class CountdownLatchDemo implements Runnable{


    private final CountDownLatch latch;
    private final String name;
    private final String dish;
    private final long cookingTime;

    public CountdownLatchDemo(CountDownLatch latch, String name, String dish, long cookingTime) {
        this.latch = latch;
        this.name = name;
        this.dish = dish;
        this.cookingTime = cookingTime;
    }

    @Override
    public void run(){
        try {
            System.out.println("Chef "+this.name+" is preparing "+this.dish+".");
            Thread.sleep(this.cookingTime);
            System.out.println("Chef "+this.name+" has finished cooking "+this.dish+".");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
