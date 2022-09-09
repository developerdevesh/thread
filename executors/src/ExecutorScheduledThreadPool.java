import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorScheduledThreadPool {

    public static void main(String[] args) {

        //for scheduling the tasks
        //more threads are created if required
        //delay queue-task come on top on the basis of execution time
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        //schedule task to run after 10 seconds delay
        service.schedule(new Task(), 10, TimeUnit.SECONDS);

        //schedule tasks to run after every 10 seconds when the task was started previously
        service.scheduleAtFixedRate(new Task(), 5, 10, TimeUnit.SECONDS);

        //schedule task every 10 seconds after the task is completed previously - initial delay is 5
        service.scheduleWithFixedDelay(new Task(), 5, 10, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }

}
