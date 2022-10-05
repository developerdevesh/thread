package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableForLoopTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //create a pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        //submit the task for execution
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new Task());
            futureList.add(future);
        }

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = futureList.get(i);
            Integer result = future.get();//blocking
            System.out.println("Result: " + result);
            System.out.println("Thread name " + Thread.currentThread().getName());
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
            return new Random().nextInt();
        }
    }

}
