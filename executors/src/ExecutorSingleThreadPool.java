import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSingleThreadPool {

    public static void main(String[] args) {

        //run tasks sequentially
        //blocking queue
        //recreate thread if it is killed
        ExecutorService service = Executors.newSingleThreadExecutor();

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
