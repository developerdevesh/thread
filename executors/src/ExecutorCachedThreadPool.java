import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCachedThreadPool {

    public static void main(String[] args) {

        //for lot of short lived tasks
        //single sized synchronous queue
        //any nymber of threads
        //if thread is idle for 60 seconds, kill the thread
        ExecutorService service = Executors.newCachedThreadPool();

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
