package callable;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //create a pool
        ExecutorService service= Executors.newFixedThreadPool(10);
        //submit the task for execution
        Future<Integer> future= service.submit(new Task());

        Integer result=future.get(); //blocking
        System.out.println("Result: "+result);
        System.out.println("Thread name " + Thread.currentThread().getName());
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
