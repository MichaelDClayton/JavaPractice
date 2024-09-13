package concurrency;

public class ThreadWithExtendingThread extends Thread{
    public static void main(String[] args) {
        ThreadWithExtendingThread thread = new ThreadWithExtendingThread();
        thread.start();
    }

    public void run(){
        System.out.println("Starting Thread With Extending Thread");
        System.out.println("Ending Thread With Extending Thread");

    }
}
