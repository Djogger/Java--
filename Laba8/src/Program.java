import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DataProcessor {
        int order();
    }

    public static class DataManager {
        String filePath1;
        String filePath2;
        List<String> list;
        List<String> sortedList;
        List<String> resultList;

        public DataManager(String path1, String path2) {
            this.filePath1 = path1;
            this.filePath2 = path2;
        }

        public void registerDataProcessor(DataManager dataManager) {
            Class<?> type = dataManager.getClass();
            Method[] methods = type.getMethods();

            Arrays.stream(methods)
                  .filter(method -> method.isAnnotationPresent(DataProcessor.class))
                  .sorted(Comparator.comparingInt(method -> method.getAnnotation(DataProcessor.class).order()))
                  .forEach(method -> {
                      try {
                          method.invoke(dataManager);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  });
        }

        @DataProcessor(order = 1)
        public void loadData() throws FileNotFoundException {
            File file = new File(filePath1);

            Scanner scanner = new Scanner(file);

            list = new ArrayList<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                list.add(line);
            }

            for (String string : list) {
                System.out.println(string);
            }

            System.out.println(" ");
        }

        @DataProcessor(order = 2)
        public void processData() throws InterruptedException {
            sortedList = list.stream().filter(x -> {
                return Integer.parseInt(x.substring(x.lastIndexOf(' ') + 1)) < 55;
            }).toList();

            ExecutorService executorService = Executors.newFixedThreadPool(sortedList.size());

            AtomicInteger startIndex = new AtomicInteger(0);
            resultList = new ArrayList<>(sortedList);

            for (int i = 0; i < sortedList.size(); i++) {
                int index = startIndex.get();

                executorService.execute(() -> {
                    StringBuilder string = new StringBuilder(sortedList.get(index));

                    StringBuilder resultString = string.replace(2,2, " {Подходящий}");

                    resultList.set(index, resultString.toString());
                });

                startIndex.set(i + 1);
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }

        @DataProcessor(order = 3)
        public void saveData() throws IOException {
            FileWriter writer = new FileWriter(filePath2, false);
            writer.write("Дата: " + String.valueOf(java.time.LocalDate.now()) + "\n");

            for (String string : resultList) {
                writer.write(string + "\n");
            }

            writer.write("\n");
            writer.close();
        }
    }

    public static void main(String[] args) {
        String filePath1 = "src/readFile.txt";
        String filePath2 = "src/receivingFile.txt";

        DataManager dataManager = new DataManager(filePath1, filePath2);

        dataManager.registerDataProcessor(dataManager);

        for (String a : dataManager.resultList) {
            System.out.println(a);
        }
    }
}
