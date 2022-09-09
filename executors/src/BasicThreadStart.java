public class BasicThreadStart {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(new Task());
            t1.start();
        }
        System.out.println("Thread name " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread - " + Thread.currentThread().getName() + " performing it's job");
        }
    }

}
