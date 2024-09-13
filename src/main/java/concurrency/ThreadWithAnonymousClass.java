package concurrency;

public class ThreadWithAnonymousClass {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Starting Thread with Anonymous Class");
            System.out.println("Ending Thread with Anonymous Class");
        }
    }
}
