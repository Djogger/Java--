import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
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

    public static String replaceVovels(String string) {
        char[] Letters = new char[] {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'};

        for (int i = Letters.length - 1; i >= 0; i--) {
            char letter = Letters[i];
            string = string.replace(letter, '*');
        }

        return string;
    }

    public static String stringTransform(String word) {
        String upperWord = word.toUpperCase();  // Для увеличения буквы, присоединяемой к "Double".
        
        word = word.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder(word);

        char[] Array = upperWord.toCharArray();
        
        String itog = null;

        for (int i = Array.length - 1; i > 0; i--) {
            char firstLetter = Array[i];
            char secondLetter = Array[i-1];

            if (firstLetter == secondLetter) {
                String changeWord = "Double" + firstLetter;
                itog = (stringBuilder.replace(i-1, i+1, changeWord)).toString();
            }
        }
        
        return itog;
    }

    public static boolean doesBlockFit(int x, int y, int z, int x2, int y2) {
        int squareOfHole = x2 * y2;

        int squareOfFirstSide = x * y;
        int squareOfSecondSide = x * z;
        int squareOfThirdSide = y * z;

        if (squareOfFirstSide <= squareOfHole || squareOfSecondSide <= squareOfHole || squareOfThirdSide <= squareOfHole) {
            return true;
        }

        return false;
    }

    public static boolean numCheck(int number) {
        String string_n = Integer.toString(number);  // Класс Integer предоставляет возможность
                                                     // преобразовать число в String.
        char[] iterNum = string_n.toCharArray();

        double result = 0;

        for (int i = 0; i < iterNum.length; i++) {
            result += Math.pow(Integer.parseInt(String.valueOf(iterNum[i])), 2);
        }

        int itog = (int) result;

        if (number % 2 == itog % 2) {
            return true;
        }

        return false;
    }

    public static int countRoots(int[] arguments) {
        int a = arguments[0];
        int b = arguments[1];
        int c = arguments[2];

        int discriminant = b*b - 4*a*c;

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean salesData(String[][] dataArray) {
        int biggestNumber = 0;
        int biggestNumberOfPoducts = 0;

        for (int x = 0; x < dataArray.length; x++) {
            int number = 0;
            int numberOfProducts = 0;

            for (int y = 0; y < dataArray[x].length; y++) {
                String word = dataArray[x][y];

                if (word.startsWith("Shop")) {
                    number++;

                    if (number > biggestNumber) {
                        biggestNumber = number;
                    }
                } else {
                    numberOfProducts++;

                    if (numberOfProducts > biggestNumberOfPoducts) {
                        biggestNumberOfPoducts = numberOfProducts;
                    }
                }
            }
        }

        for (int x = 0; x < dataArray.length; x++) {
            for (int y = 0; y < dataArray[x].length; y++) {
                String word = dataArray[x][y];

                if (dataArray[x].length - biggestNumberOfPoducts == biggestNumber) {
                    if (!word.startsWith("Shop")) {
                        System.out.println(word);
                    }
                }
            }
        }

        return false;
    }

    /*
    public static List<String> salesData(String[][] dataArray) {


        ArrayList<Integer> coordinates = new ArrayList<>();

        for (int x = 0; x < dataArray.length; x++) {
            int d = dataArray[x].length;

            if (d == 5) {
                coordinates.add(x);
            }
        }

        String[] itog = new String[coordinates.size()];

        for (int y = 0; y < coordinates.size(); y++) {
            itog[y] = dataArray[coordinates.get(y)][0];
        }

        return Arrays.asList(itog);
    }
    */

    public static boolean validSplit(String string) {
        String[] words = string.split(" ");

        for (int num_array_word = 0; num_array_word < words.length - 1; num_array_word++) {
            String word = words[num_array_word];
            String next_word = words[num_array_word+1];

            char word_last_char = word.charAt(word.length()-1);
            char next_word_first_char = next_word.charAt(0);

            if (word_last_char != next_word_first_char) {
                return false;
            }
        }

        return true;
    }

    public static boolean waveForm(int[] array_of_numbers) {
        List<String> last_number = new ArrayList<>();

        for (int i = 0; i < array_of_numbers.length - 1; i++) {
            if (array_of_numbers[i] < array_of_numbers[i+1]) {
                last_number.add("<");
            } else {
                last_number.add(">");
            }

            if (i > 0) {
                if (last_number.get(i).equals(last_number.get(i-1))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static char commonVovel(String sentence) {
        sentence = sentence.toLowerCase();

        String vowels = "aeiou";
        int[] vowelCount = new int[5];
        int maxCount = 0;
        char mostCommonVowel = ' ';

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (vowels.indexOf(c) != -1) {
                vowelCount[vowels.indexOf(c)]++;
            }
        }

        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] > maxCount) {
                maxCount = vowelCount[i];
                mostCommonVowel = vowels.charAt(i);
            }
        }

        return mostCommonVowel;
    }

    /*
    public static String commonVovel(String string) {
        string = string.toLowerCase();

        int a = countLetter(string, 'a');
        int e = countLetter(string, 'e');
        int i = countLetter(string, 'i');
        int o = countLetter(string, 'o');
        int u = countLetter(string, 'u');
        int y = countLetter(string, 'y');


        int[] array_of_numbers = new int[6];

        array_of_numbers[0] = a;
        array_of_numbers[1] = e;
        array_of_numbers[2] = i;
        array_of_numbers[3] = o;
        array_of_numbers[4] = u;
        array_of_numbers[5] = y;

        Arrays.sort(array_of_numbers);

        int biggest_number = array_of_numbers[5];

        if (a == biggest_number) {
            return "a";
        } else if (e == biggest_number) {
            return "e";
        } else if (i == biggest_number) {
            return "i";
        } else if (o == biggest_number) {
            return "o";
        }else if (u == biggest_number) {
            return "u";
        }else if (y == biggest_number) {
            return "y";
        }

        return "Гласных букв нет :(";
    }

    // countLetter связан с методом commonVovel;
    public static int countLetter(String word, char letter) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }

        return count;
    }

     */

    public static String dataScience(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int arithmetic_number = 0;

            for (int k = 0; k < 5; k++) {
                arithmetic_number += arrays[k][i];
            }

            arithmetic_number /= 5;

            arrays[i][i] = arithmetic_number;
        }

        return Arrays.deepToString(arrays);
    }
}




