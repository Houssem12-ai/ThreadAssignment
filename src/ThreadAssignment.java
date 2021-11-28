public class ThreadAssignment {

    static class Counter {
        void count() {
            for ( int i = 350 ; i>=1 ; i-- ){
                System.out.println(i);
            }
            System.out.println("_____finish_____ !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized(counter) {
                counter.count();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread one = new MyThread(counter);
        MyThread two = new MyThread(counter);
        one.start();
        two.start();
        try {
            one.join();
            two.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done  !");
    }
}
