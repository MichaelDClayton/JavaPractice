import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test extends Thread{
    private static int seats = 100;
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args){
        Test t = new Test();
       Thread one = new Thread(t,"1");one.start();
       Thread two = new Thread(t,"2");two.start();

    }
    @Override
    public void run(){
        while(seats != 0){
            lock.lock();
            try{
                if(seats > 0){

                    try{
                        Thread.sleep(50);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                    seats--;
                    System.out.println("Thread: "+Thread.currentThread().getName()+"...Seats Left: "+seats);
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
