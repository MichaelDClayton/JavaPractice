package concurrency;

public class DaemonUserThreadExample {

    public static void main(String[] args){
        Thread backgroundThread = new Thread(new DaemonThreadHelper());
        Thread userThread = new Thread(new UserThreadHelper());
        backgroundThread.setDaemon(true);

        backgroundThread.start();
        userThread.start();

    }


}
class DaemonThreadHelper implements Runnable{
    @Override
    public void run(){
        int count = 0;
        while(count < 500){
            System.out.println("DaemonThreadHelper running...");
            count++;
        }
        System.out.println("DaemonThreadHelper exiting!");
    }
}

class UserThreadHelper implements Runnable{
    @Override
    public void run(){
        int count = 0;
        while(count < 100){
            System.out.println("UserThreadHelper running...");
            count++;
        }
        System.out.println("UserThreadHelper exiting!");
    }
}