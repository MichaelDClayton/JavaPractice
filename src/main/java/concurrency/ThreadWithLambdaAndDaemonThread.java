package concurrency;

public class ThreadWithLambdaAndDaemonThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread thread = new Thread(runnable);
        //stops the thread after the main thread has stopped.
        //JVM is terminated.
        thread.setDaemon(true);
        thread.start();
        sleep(3100);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
