package callable;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTestTimeout {

    public static void main(String[] args) {

        //create a pool
        ExecutorService service= Executors.newFixedThreadPool(10);
        //submit the task for execution
        Future<Integer> future= service.submit(new Task());

        Integer result= null; //blocking
        try {
            result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Timed out.. perform other options");
        }
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
