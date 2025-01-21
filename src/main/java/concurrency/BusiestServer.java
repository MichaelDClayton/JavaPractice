package concurrency;

import java.util.ArrayList;
import java.util.List;


public class BusiestServer {
    public static void main(String[] args) {
        int serverCount = 3;
        int[] requests = {1, 2, 3, 4, 5};
        long[] workload = {5, 2, 3, 3, 3};
        List<CustomJob> requestList = new ArrayList<>();
        for (int i = 0; i < requests.length; i++) {
            CustomJob job = new CustomJob(requests[i], workload[i]);
            requestList.add(job);
        }


        Server server = new Server(3, 0, requestList);
        Thread producer = new Thread(server::produce);
        producer.start();

        Server worker1 = new Server(3, 0, requestList, 0);
        Thread workerThread1 = new Thread(worker1::consume);
        workerThread1.start();

        Server worker2 = new Server(3, 0, requestList, 1);
        Thread workerThread2 = new Thread(worker2::consume);
        workerThread2.start();

        Server worker3 = new Server(3, 0, requestList, 2);
        Thread workerThread3 = new Thread(worker3::consume);
        workerThread3.start();


    }
}


class Server {

    private final Integer max;
    private final Integer min;
    private final Object lock = new Object();
    List<CustomJob> queue;
    private int serverId;
    private int jobCount = 0;
    List<CustomJob> requesList;

    public Server(Integer max, Integer min, List<CustomJob> requesList) {
        this.max = max;
        this.min = min;
        this.queue = new ArrayList<>();
        this.requesList = requesList;

    }

    public Server(Integer max, Integer min, List<CustomJob> requesList, int serverId) {
        this.max = max;
        this.min = min;
        this.queue = new ArrayList<>();
        this.requesList = requesList;
        this.serverId = serverId;

    }

    public int getJobCount() {
        return this.jobCount;
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public void produce() {
        synchronized (lock) {
            while (true) {
                if (queue.size() == max) {
                    System.out.println("Queue is full..." );
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {

                   if(!requesList.isEmpty()){
                       CustomJob currentJob = this.requesList.removeFirst();
                       queue.add(currentJob);
                       System.out.println("Job #" + currentJob.getRequestId() + " Added to the queue");
                       try {
                           Thread.sleep(currentJob.getWorkload());
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                       lock.notify();
                   }
                }

            }
        }
    }

    public void consume() {
        synchronized (lock) {
            while (true) {
                if (queue.size() == min) {
                    System.out.println("Waiting for items to be added to queue");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    CustomJob currentJob = queue.removeFirst();
                    int jobCount = this.getJobCount() + 1;
                    this.setJobCount(jobCount);
                    System.out.println(this.serverId + " job count is: " + this.getJobCount());
                    try {
                        Thread.sleep(currentJob.getWorkload());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notify();
                }

            }
        }
    }
}

class CustomJob {
    private int requestId;
    private long workload;


    public CustomJob(int requestId, long workload) {
        this.requestId = requestId;
        this.workload = workload;
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public long getWorkload() {
        return workload;
    }

    public void setWorkload(long workload) {
        this.workload = workload;
    }


}