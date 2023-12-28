
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + counter.getCount());
    }

    public static class Counter {
        private int count;
        public synchronized void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }

    public static class MyThread extends Thread {
        private Counter counter;
        public MyThread(Counter counter) {
            this.counter = counter;
        }
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }
}
