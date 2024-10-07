package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorLambda {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread Name: "+name);
        });

        try{
            System.out.println("Shutting down thread!");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }

    }
}
