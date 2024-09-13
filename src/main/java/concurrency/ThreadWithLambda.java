package concurrency;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Starting Thread with Lambda!");
            System.out.println("************");
            String threadName = Thread.currentThread().getName();
            System.out.printf("Thread running has name: %s \n",threadName);
            System.out.println("************");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Ending Thread with Lambda!");

        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
