package concurrency.no_race_condition_with_shared_count;

import concurrency.race_condition_with_shared_count.MyRunnableWithRaceCondition;

public class ThreadsWithRaceNoCondition {


    public static void main(String[] args) {
        MyRunnableWithNoRaceCondition runnable1 = new MyRunnableWithNoRaceCondition();
        MyRunnableWithRaceCondition runnable2 = new MyRunnableWithRaceCondition();

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
