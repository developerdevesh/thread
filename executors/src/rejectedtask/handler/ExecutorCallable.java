package rejectedtask.handler;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Implementation of Future tasks
 */
public class ExecutorCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //fix number of threads
        //blocking queue-thread safe
        ExecutorService service = Executors.newFixedThreadPool(100);

        //submit the tasks for execution
        Future<Integer> result = service.submit(new Task());

        //*** perform some unrelated operations

        System.out.println("Result of submitted task is : " + result.get());//blocks until the future is ready after completion

        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
}
