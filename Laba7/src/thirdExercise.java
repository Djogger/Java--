import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class thirdExercise {
    public static void main(String[] args) {
        // Думаю ничего не будет, если я поменяю килограммы на тонны :3
        Good good1 = new Good("Engine", 55, 1);
        Good good2 = new Good("Fuel", 25, 1);
        Good good3 = new Good("Radar", 20, 1);
        Good good4 = new Good("Bullets", 40, 1);
        Good good5 = new Good("Carbon-plates", 65, 1);
        Good good6 = new Good("Tracks", 80, 1);
        Good good7 = new Good("Optical sight", 5, 1);
        Good good8 = new Good("Tracks", 80, 1);
        Good good9 = new Good("Electron-optical complex of active protection", 5, 1);

        Good[] warehouse1 = new Good[] {good1, good2, good3, good4, good5, good6, good7, good8, good9};
        ArrayList<Good> warehouse2 = new ArrayList<>();

        LoaderRealization loaderRealization = new LoaderRealization(warehouse1, warehouse2);

        loaderRealization.run();
    }


    public interface Loader {
        Good getGood();
    }


    public static class LoaderRealization implements Loader {
        private ExecutorService executorService;
        private Good[] warehouse1;
        private ArrayList<Good> warehouse2;
        private int index = 0;


        public LoaderRealization(Good[] warehouse1, ArrayList<Good> warehouse2) {
            this.warehouse1 = warehouse1;
            this.warehouse2 = warehouse2;
        }

        public void run() {
            executorService = Executors.newFixedThreadPool(3);

            Semaphore semaphore = new Semaphore(1);

            AtomicInteger resultWeight = new AtomicInteger(0);

            for (int i = 0; i < 3; i++) {
                executorService.execute(() -> {
                    try {
                        semaphore.acquire();

                        for (int j = 0; j < warehouse1.length; j++) {
                            Good good = getGood();

                            if (good == null) {
                                break;
                            }

                            if (resultWeight.get() + good.weight <= 150) {
                                warehouse2.add(good);
                                good.downgradeQuantity();

                                resultWeight.addAndGet(good.weight);
                            }
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        semaphore.release();
                    }
                });
            }

            executorService.shutdown();
            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (Good good : warehouse2) {
                System.out.println("Name: " + good.name + " | Weight: " + good.weight);
            }

            System.out.println("\n" + resultWeight.get());
        }

        @Override
        public synchronized Good getGood() {
            if (warehouse1[index].quantity > 0) {
                Good good = warehouse1[index];
                good.downgradeQuantity();
                return good;
            }

            if (index + 1 < warehouse1.length) {
                index += 1;
                return warehouse1[index];
            }

            return null;
        }
    }


    public static class Good {
        String name;
        int weight;
        int quantity;

        public Good(String name, int weight, int quantity) {
            this.name = name;
            this.weight = weight;
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void downgradeQuantity() {
            quantity -= 1;
        }
    }
}
