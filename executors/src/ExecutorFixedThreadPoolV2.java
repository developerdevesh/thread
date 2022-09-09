import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedThreadPoolV2 {

    public static void main(String[] args) {

        //for CPU intensive tasks
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Available core size - " + coreCount);
        //create a fix thread pool of 10 threads
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new CPUTask());
        }
        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    static class CPUTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }

}
