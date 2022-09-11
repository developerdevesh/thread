package rejectedtask.handler;

class Task implements Runnable {
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