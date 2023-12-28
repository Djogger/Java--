import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class firstExercise {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[] {2, 4, 1, 5, 19, 1, 5, 1, 2, 5};

        int[] threadsQuantity = findQuantity(array.length, 1);

        ExecutorService executorService = Executors.newFixedThreadPool(threadsQuantity[1]);

        AtomicInteger startIndex = new AtomicInteger(0);
        AtomicInteger endIndex = new AtomicInteger(threadsQuantity[0]);
        AtomicInteger result = new AtomicInteger(0);

        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < threadsQuantity[1]; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();

                    int indexStart = startIndex.get();
                    int indexEnd = endIndex.get();

                    startIndex.set(indexEnd);
                    endIndex.addAndGet(threadsQuantity[0]);

                    for (int k = indexStart; k < indexEnd; k++) {
                        result.addAndGet(array[k]);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println(result.get());
    }

    public static int[] findQuantity(int array, int threads) {
        if (array % 2 != 0) {
            return new int[] {array, threads};
        }

        return findQuantity(array / 2, threads * 2);
    }
}
