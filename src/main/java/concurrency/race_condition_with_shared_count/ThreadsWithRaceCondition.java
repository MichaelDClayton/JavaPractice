package concurrency.race_condition_with_shared_count;

public class ThreadsWithRaceCondition {

    public static void main(String[] args) {
        MyRunnableWithRaceCondition runnable = new MyRunnableWithRaceCondition();


        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
