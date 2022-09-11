import java.util.concurrent.*;

//Imlementation of RejectedTaskHandler in java executors
public class ExecutorRejectedTaskHandlerFixedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        //maximum queue size : 2
        BlockingQueue<Runnable> blockingQueue =
                new LinkedBlockingQueue<Runnable>(2);

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

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }


    static class RejectedTaskHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task rejected" + r.toString());

            //add again the rejected task in the queue
//            try {
//                executor.getQueue().put(r);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }


    public static class CustomThreadPoolExecutor extends ThreadPoolExecutor {

        public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                        long keepAliveTime, TimeUnit unit,
                                        BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
//            System.out.println("Perform beforeExecute() logic");
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            if (t != null) {
//                System.out.println("Perform exception handler logic");
            }
//            System.out.println("Perform afterExecute() logic");
        }
    }

}
