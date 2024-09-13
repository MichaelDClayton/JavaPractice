package concurrency;

public class StoppingThreads {
    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Requesting Stop.");
        stoppableRunnable.requestStop();
        System.out.println("Stop requested.");
    }

    public static class StoppableRunnable implements Runnable {
        /*
        Never call stop on a Thread...this will leave application in
        unreliable state.

        Instead, manage the stop yourself.
         */
        private boolean stopRequested = false;

        private synchronized void requestStop() {
            this.stopRequested = true;
        }

        private synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("Starting StoppableRunnable thread!");
            while (!isStopRequested()) {
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable thread Stopped!");

        }
    }
}
