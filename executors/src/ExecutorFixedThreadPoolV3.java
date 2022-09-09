import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedThreadPoolV3 {

    public static void main(String[] args) {

        //much higher count for IO tasks
        //fix number of threads
        //blocking queue-thread safe
        ExecutorService service = Executors.newFixedThreadPool(100);

        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new IOTask());
        }
        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    static class IOTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }

}
