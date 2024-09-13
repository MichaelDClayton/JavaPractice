package concurrency.race_condition_with_shared_count;

public class MyRunnableWithRaceCondition implements Runnable{
    volatile int count = 0;


    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
                this.count++;
        }
        System.out.println(Thread.currentThread().getName()+" : "+this.count);
    }
}
