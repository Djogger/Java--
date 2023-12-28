import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class secondExercise {
    public static void main(String[] args) throws InterruptedException {
        int[][] array = new int[][] {{5, 4, 2}, {8}};

        int[] threadsQuantity = findQuantityValue(array.length, 1);

        ExecutorService executorService = Executors.newFixedThreadPool(threadsQuantity[1]);

        int[] result = new int[threadsQuantity[1]];

        for (int i = 0; i < threadsQuantity[1]; i++) {
            int validI = i;

            executorService.execute(() -> {
                int calculation = 0;

                for (int k = validI * threadsQuantity[0]; k < (validI + 1) * threadsQuantity[0]; k++) {
                    for (int j = 0; j < array[k].length; j++) {
                        calculation += array[k][j];
                    }
                }

                result[validI] = calculation;
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        if (result.length == 1) {
            System.out.println(result[0]);
            return;
        }

        int itog = 0;

        for (int numbers : result) {
            itog += numbers;
        }

        System.out.println(itog);
    }

    public static int[] findQuantityValue(int array, int threads) {
        if (array % 2 != 0) {
            return new int[] {array, threads};
        }

        return findQuantityValue(array / 2, threads * 2);
    }
}
