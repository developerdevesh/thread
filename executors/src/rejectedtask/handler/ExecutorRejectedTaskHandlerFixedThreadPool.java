package rejectedtask.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//Imlementation of RejectedTaskHandler in java executors
public class ExecutorRejectedTaskHandlerFixedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        //maximum queue size : 2
        BlockingQueue<Runnable> blockingQueue =
                new ArrayBlockingQueue<>(2);

        //Custome Threadpool executor
        CustomThreadPoolExecutor executor =
                new CustomThreadPoolExecutor(4, 5, 5, TimeUnit.SECONDS,
                        blockingQueue);

        RejectedTaskHandler rejectedHandler = new RejectedTaskHandler();
        executor.setRejectedExecutionHandler(rejectedHandler);
        //submit 20 the tasks for execution
        //Note: only 7 tasks(5-max pool size + 2-queue size) will be executed and rest will be rejected as queue will be overflowed
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }
        System.out.println("Thread name " + Thread.currentThread().getName());


    }
}
