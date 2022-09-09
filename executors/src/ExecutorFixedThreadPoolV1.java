import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedThreadPoolV1 {

    public static void main(String[] args) {

        //create a fix thread pool of 10 threads
        ExecutorService service= Executors.newFixedThreadPool(10);

        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }

}
