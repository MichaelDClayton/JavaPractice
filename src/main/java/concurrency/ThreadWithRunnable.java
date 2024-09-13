package concurrency;

public class ThreadWithRunnable implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadWithRunnable());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Starting Thread with Implementing Runnable");
        System.out.println("Ending Thread with Implementing Runnable");
    }
}
