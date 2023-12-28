import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rogramNelli {
        public static void main(String[] args) {
            // Задание 1:
            System.out.println("Задание 1:");
            System.out.println(replaceVovels("apple"));
            System.out.println(replaceVovels("Even if you did this task not by yourself, you have to " +
                    "understand every single line of code.\n"));

            // Задание 2:
            System.out.println("Задание 2:");
            System.out.println(stringTransform("hello"));
            System.out.println(stringTransform("bookkeeper\n"));

            // Задание 3:
            System.out.println("Задание 3:");
            System.out.println(doesBlockFit(1, 3, 5, 4, 5));
            System.out.println(doesBlockFit(1, 8, 1, 1, 1));
            System.out.println(doesBlockFit(1, 2, 2, 1, 1));

            // Задание 4:
            System.out.println("\nЗадание 4:");
            System.out.println(numCheck(243));
            System.out.println(numCheck(52));

            // Задание 5:
            System.out.println("\nЗадание 5:");
            System.out.println(countRoots(new int[]{1, -3, 2}));
            System.out.println(countRoots(new int[]{2, 5, 2}));
            System.out.println(countRoots(new int[]{1, -6, 9}));

            // Задание 6:
            System.out.println("\nЗадание 6:");
            salesData(new String[][]{
                    {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                    {"Banana", "Shop2", "Shop3", "Shop4"},
                    {"Orange", "Shop1", "Shop3", "Shop4"},
                    {"Pear", "Shop2", "Shop4"}
            });
            salesData(new String[][]{
                    {"Fridge", "Shop2", "Shop3"},
                    {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                    {"Laptop", "Shop3", "Shop4"},
                    {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
            });

            // Задание 7:
            System.out.println("\nЗадание 7:");
            System.out.println(validSplit("apple eagle egg goat"));
            System.out.println(validSplit("cat dog goose fish"));

            // Задание 8:
            System.out.println("\nЗадание 8:");
            System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
            System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
            System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));

            // Задание 9:
            System.out.println("\nЗадание 9:");
            System.out.println(commonVovel("Hello world"));
            System.out.println(commonVovel("Actions speak louder than words."));

            // Задание 10:
            System.out.println("\nЗадание 10:");
            System.out.println(dataScience(new int[][]{{1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {5, 5, 5, 5, 5},
                    {7, 4, 3, 14, 2},
                    {1, 0, 11, 10, 1}}));
            System.out.println(dataScience(new int[][]{{6, 4, 19, 0, 0},
                    {81, 25, 3, 1, 17},
                    {48, 12, 60, 32, 14},
                    {91, 47, 16, 65, 217},
                    {5, 73, 0, 4, 21}}));
        }

        //Задание 1. Создайте функцию, которая принимает строку и заменяет все гласные буквы на символ «*».
        public static String replaceVovels(String string) {
            // Определение массива символов с гласными буквами
            char[] Letters = new char[]{'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'};

            // Проход по массиву гласных букв в обратном порядке
            for (int i = Letters.length - 1; i >= 0; i--) {
                // Получение текущей гласной буквы
                char letter = Letters[i];
                // Замена всех вхождений гласной буквы в строке на символ '*'
                string = string.replace(letter, '*');
            }
            return string;
        }

        //Задание 2. Напишите функцию, которая принимает строку и заменяет две идущие подряд буквы по шаблону «Double*».
        public static String stringTransform(String word) {
            // Преобразование первой буквы в верхний регистр для присоединения к "Double"
            String upperWord = word.toUpperCase();

            // Преобразование строки в нижний регистр
            word = word.toLowerCase();

            // Создание объекта StringBuilder для модификации строки
            StringBuilder stringBuilder = new StringBuilder(word);

            // Преобразование верхнего регистра строки в массив символов
            char[] Array = upperWord.toCharArray();

            // Инициализация переменной itog со значением null
            String itog = null;

            // Итерация по массиву символов в обратном порядке
            for (int i = Array.length - 1; i > 0; i--) {
                // Получение текущей и следующей буквы
                char firstLetter = Array[i];
                char secondLetter = Array[i - 1];

                // Проверка, равны ли текущая и следующая буква
                if (firstLetter == secondLetter) {
                    // Создание нового слова с префиксом "Double" и текущей буквой
                    String changeWord = "Double" + firstLetter;
                    // Замена подстроки, содержащей текущую и следующую буквы, на новое слово
                    itog = (stringBuilder.replace(i - 1, i + 1, changeWord)).toString();
                }
            }
            return itog;
        }

        //Задание 3. Помогите ребенку разобраться с игрушкой на развитие - поместится ли параллелепипед в коробку
        // с отверстиями определенных параметров. Напишите функцию, которая принимает три измерения игрушечного
        // блока: высоту(a), ширину(b) и глубину(c) и возвращает true, если этот блок может поместиться в
        // отверстие с шириной(w) и высотой(h).
        public static boolean doesBlockFit(int x, int y, int z, int x2, int y2) {
            // Вычисление площади отверстия
            int squareOfHole = x2 * y2;

            // Вычисление площади первой стороны блока
            int squareOfFirstSide = x * y;
            // Вычисление площади второй стороны блока
            int squareOfSecondSide = x * z;
            // Вычисление площади третьей стороны блока
            int squareOfThirdSide = y * z;

            // Проверка, помещается ли блок в отверстие хотя бы одной из сторон
            if (squareOfFirstSide <= squareOfHole || squareOfSecondSide <= squareOfHole || squareOfThirdSide <= squareOfHole) {
                return true;
            }

            return false;
        }

        //Задание 4. Создайте функцию, которая принимает число в качестве входных данных и возвращает true,
        // если сумма квадратов его цифр имеет ту же четность, что и само число.
        // В противном случае верните false
        public static boolean numCheck(int number) {
            // Преобразование числа в строку
            String string_n = Integer.toString(number);

            // Преобразование строки в массив символов
            char[] iterNum = string_n.toCharArray();

            // Переменная для хранения результата
            double result = 0;

            // Итерация по каждому символу числа
            for (int i = 0; i < iterNum.length; i++) {
                // Преобразование символа обратно в число и возведение в квадрат
                result += Math.pow(Integer.parseInt(String.valueOf(iterNum[i])), 2);
            }

            // Преобразование результата в целое число
            int itog = (int) result;

            // Проверка четности числа и результата
            if (number % 2 == itog % 2) {
                return true;
            }

            return false;
        }

        //Задание 5. Создайте метод, который берет массив целых чисел-коэффициентов и возвращает
        // количество целочисленных корней квадратного уравнения.
        public static int countRoots(int[] arguments) {
            // Извлечение коэффициентов из массива аргументов
            int a = arguments[0];
            int b = arguments[1];
            int c = arguments[2];

            // Вычисление дискриминанта
            int discriminant = b * b - 4 * a * c;

            // Проверка значений дискриминанта и возврат соответствующего количества корней
            if (discriminant > 0) {
                return 2; // Два действительных корня
            } else if (discriminant == 0) {
                return 1; // Один действительный корень
            } else {
                return 0; // Нет действительных корней
            }
        }

        //Задание 6. Создайте метод, который принимает двумерный массив, представляющий информацию о
        // продажах разных товаров в различных магазинах, и возвращает товары, которые были проданы в
        // каждом из магазинов.
        public static boolean salesData(String[][] dataArray) {
            // Инициализация переменных для хранения наибольшего числа и количества товаров
            int biggestNumber = 0;
            int biggestNumberOfPoducts = 0;

            // Цикл по строкам массива данных о продажах
            for (int x = 0; x < dataArray.length; x++) {
                // Инициализация переменных для текущего числа магазинов и количества товаров
                int number = 0;
                int numberOfProducts = 0;

                // Цикл по столбцам массива данных о продажах
                for (int y = 0; y < dataArray[x].length; y++) {
                    // Получение текущего элемента массива
                    String word = dataArray[x][y];

                    // Проверка, начинается ли слово с "Shop"
                    if (word.startsWith("Shop")) {
                        // Увеличение числа магазинов
                        number++;

                        // Проверка, является ли текущее число магазинов наибольшим
                        if (number > biggestNumber) {
                            biggestNumber = number;
                        }
                    } else {
                        // Увеличение количества товаров
                        numberOfProducts++;

                        // Проверка, является ли текущее количество товаров наибольшим
                        if (numberOfProducts > biggestNumberOfPoducts) {
                            biggestNumberOfPoducts = numberOfProducts;
                        }
                    }
                }
            }

            // Цикл по массиву данных о продажах для вывода результатов
            for (int x = 0; x < dataArray.length; x++) {
                for (int y = 0; y < dataArray[x].length; y++) {
                    // Получение текущего элемента массива
                    String word = dataArray[x][y];

                    // Проверка условия для вывода данных
                    if (dataArray[x].length - biggestNumberOfPoducts == biggestNumber) {
                        if (!word.startsWith("Shop")) {
                            // Вывод слова
                            System.out.println(word);
                        }
                    }
                }
            }

            return false;
        }

        //Задание 7. Создайте функцию, которая определяет, можно ли разбить заданное предложение на слова так,
        // чтобы каждое слово начиналось с последней буквы предыдущего слова.
        public static boolean validSplit(String string) {
            // Разбиение строки на слова
            String[] words = string.split(" ");

            // Цикл по словам (исключая последнее слово)
            for (int num_array_word = 0; num_array_word < words.length - 1; num_array_word++) {
                // Получение текущего слова и следующего слова
                String word = words[num_array_word];
                String next_word = words[num_array_word + 1];

                // Получение последнего символа текущего слова и первого символа следующего слова
                char word_last_char = word.charAt(word.length() - 1);
                char next_word_first_char = next_word.charAt(0);

                // Проверка, является ли последний символ текущего слова разным от первого символа следующего слова
                if (word_last_char != next_word_first_char) {
                    return false;
                }
            }

            // Если все пары символов были одинаковы, то разбиение считается правильным
            return true;
        }

        //Задание 8. Напишите метод, который определяет, является ли заданный массив «волнообразным».
        // Последовательность чисел считается волнообразной, если разница между соседними элементами
        // чередуется между убыванием и возрастанием
        public static boolean waveForm(int[] array_of_numbers) {
            // Создание списка для хранения символов сравнения последовательных чисел
            List<String> last_number = new ArrayList<>();

            // Цикл по элементам массива чисел (исключая последний элемент)
            for (int i = 0; i < array_of_numbers.length - 1; i++) {
                // Сравнение текущего числа с последующим числом
                if (array_of_numbers[i] < array_of_numbers[i + 1]) {
                    // Если текущее число меньше следующего, то добавляем символ "<" в список
                    last_number.add("<");
                } else {
                    // Иначе, если текущее число больше или равно следующему, то добавляем символ ">" в список
                    last_number.add(">");
                }

                // Проверка наличия повторяющихся символов сравнения
                if (i > 0) {
                    if (last_number.get(i).equals(last_number.get(i - 1))) {
                        // Если найдены повторяющиеся символы, то волновая форма считается неправильной, и метод возвращает false
                        return false;
                    }
                }
            }

            // Если отсутствуют повторяющиеся символы сравнения, то волновая форма считается правильной, и метод возвращает true
            return true;
        }

        //Задание 9. Напишите функцию, которая находит наиболее часто встречающуюся гласную в предложении.
        public static char commonVovel(String sentence) {
            // Приведение всей строки к нижнему регистру
            sentence = sentence.toLowerCase();

            // Определение списка гласных букв
            String vowels = "aeiou";

            // Создание массива для подсчета количества гласных
            int[] vowelCount = new int[5];

            // Переменные для хранения наибольшего количества и наиболее распространенной гласной буквы
            int maxCount = 0;
            char mostCommonVowel = ' ';

            // Цикл по символам в строке
            for (int i = 0; i < sentence.length(); i++) {
                // Получение текущего символа
                char c = sentence.charAt(i);

                // Проверка, является ли текущий символ гласной
                if (vowels.indexOf(c) != -1) {
                    // Если текущий символ является гласной, увеличиваем счетчик гласных букв в массиве vowelCount
                    vowelCount[vowels.indexOf(c)]++;
                }
            }

            // Цикл по элементам массива счетчиков гласных
            for (int i = 0; i < vowelCount.length; i++) {
                // Поиск наибольшего значения счетчика гласных
                if (vowelCount[i] > maxCount) {
                    // Если текущее значение счетчика гласных больше максимального значения,
                    // обновляем максимальное значение и сохраняем наиболее распространенную гласную букву
                    maxCount = vowelCount[i];
                    mostCommonVowel = vowels.charAt(i);
                }
            }

            // Возвращаем наиболее распространенную гласную букву
            return mostCommonVowel;
        }

        //Задание 10. Создайте функцию, которая принимает n целочисленных массивов длины n,
        // а затем изменяет каждый n-ый элемент n-го массива на среднее арифметическое элементов n-го
        // столбца остальных массивов.
        public static String dataScience(int[][] arrays) {
            // Цикл по внешнему массиву
            for (int i = 0; i < arrays.length; i++) {
                // Инициализация переменной для вычисления среднего арифметического
                int arithmetic_number = 0;

                // Цикл по внутреннему массиву
                for (int k = 0; k < 5; k++) {
                    // Суммирование значений элементов внутреннего массива
                    arithmetic_number += arrays[k][i];
                }

                // Вычисление среднего арифметического
                arithmetic_number /= 5;

                // Присвоение среднего значения текущему элементу массива
                arrays[i][i] = arithmetic_number;
            }

            // Возвращение массива в виде строки с помощью метода deepToString()
            return Arrays.deepToString(arrays);
        }
}
