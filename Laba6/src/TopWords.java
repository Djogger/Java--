import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "src/fileEx1.txt";

        // создаем объект File
        File file = new File(filePath);

        // создаем объект Scanner для чтения файла
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();

            if (map.containsKey(word)) {
                int quantity = map.get(word);
                quantity++;

                map.put(word, quantity);
            } else {
                map.put(word, 1);
            }
        }

        // закрываем Scanner
        scanner.close();

        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // сортируем список по убыванию количества повторений

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Сравнение по значению (Integer) в порядке убывания
                return -1 * o1.getValue().compareTo(o2.getValue());
            }
        });

        //выводим результат
        if (list.size() > 10) {
            String[] result = new String[10];

            for (int i = 0; i < 10; i++) {
                result[i] = String.valueOf(list.get(i));
            }

            System.out.println(Arrays.toString(result));
        } else {
            String[] result = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                result[i] = String.valueOf(list.get(i));
            }

            System.out.println(Arrays.toString(result));
        }
    }
}
