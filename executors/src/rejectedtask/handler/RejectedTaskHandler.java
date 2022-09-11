package rejectedtask.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Rejected task handler
 */
class RejectedTaskHandler implements RejectedExecutionHandler {

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