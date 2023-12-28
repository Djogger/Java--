import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Задание: 1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("\nЗадание: 2");
        List<String> brackets = generateBrackets(3);
        for (String bracket : brackets) {
            System.out.println(bracket);
        }

        System.out.println("\nЗадание: 3");
        List<String> brackets2 = num(4);
        for (String bracket : brackets2) {
            System.out.println(bracket);
        }

        System.out.println("\nЗадание: 4");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
//        Переводя символ в число, мы узнаём его кодировку в десятичной форме.
//        С каждым увеличением кодировки на один - по порядку меняется и буква.
//        int a = 'y';
//        System.out.println(a);

        System.out.println("\nЗадание: 5");
        System.out.println(sortingLetters("aaabbcdd"));

        System.out.println("\nЗадание: 6");
        convertToNum("eight");
        convertToNum("five hundred sixty seven");
        convertToNum("thirty one");

        System.out.println("\nЗадание: 7");
        uniqueSubstring("123412324");
        uniqueSubstring("111111111");
        uniqueSubstring("77897898");

        System.out.println("\nЗадание: 8");
        System.out.println(shortestWay(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(shortestWay(new int[][] {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}}));

        System.out.println("\nЗадание: 9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("\nЗадание: 10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }

    public static String nonRepeatable(String string) {
        StringBuilder word = new StringBuilder();

        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);

            if (word.toString().indexOf(letter) == -1) {
                word.append(letter);
            }
        }

        return word.toString();
    }


    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }


    public static List<String> num(int number) {
        List<String> result = new ArrayList<>();
        backNum(result, "", 0, 0, number);
        return result;
    }

    private static void backNum(List<String> result, String current, int zero, int one, int max) {
        if (current.length() == max) {
            result.add(current);
            return;
        }

        if (zero < max && (current.isEmpty() || current.charAt(current.length() - 1) != '0')) {
            backNum(result, current + "0", zero + 1, one, max);
        }

        if (one < max) {
            backNum(result, current + "1", zero, one + 1, max);
        }
    }

    public static String alphabeticRow(String string) {
        StringBuilder currentRow = new StringBuilder();
        StringBuilder currentRowRevers = new StringBuilder();

        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (i + 1 >= string.length()) {
                if (!currentRow.isEmpty()) {
                    currentRow.append(string.charAt(i));
                    array.add(currentRow.toString());
                }

                if (!currentRowRevers.isEmpty()) {
                    currentRowRevers.append(string.charAt(i));
                    array.add(currentRowRevers.toString());
                }

                break;
            }

            if ((int) string.charAt(i) + 1 == (int) string.charAt(i + 1)) {
                currentRow.append(string.charAt(i));
            } else if (!currentRow.isEmpty()) {
                currentRow.append(string.charAt(i));

                array.add(currentRow.toString());
                currentRow.setLength(0);
            }

            if ((int) string.charAt(i) - 1 == (int) string.charAt(i + 1)) {
                currentRowRevers.append(string.charAt(i));
            } else if (!currentRowRevers.isEmpty()) {
                currentRowRevers.append(string.charAt(i));

                array.add(currentRowRevers.toString());
                currentRowRevers.setLength(0);
            }
        }

        String longestString = "";

        for (String value: array) {
            if (value.length() > longestString.length()) {
                longestString = value;
            }
        }

        return longestString;
    }


    public static StringBuilder sortingLetters(String string) {
        StringBuilder alphabet = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (alphabet.indexOf(String.valueOf(string.charAt(i))) == -1) {
                alphabet.append(string.charAt(i));
            }
        }

        int[] countOfLetters = new int[alphabet.length()];

        StringBuilder currentString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (i + 1 >= string.length()) {
                method(currentString, string, alphabet, countOfLetters, i);
                break;
            }

            if (string.charAt(i) == string.charAt(i + 1)) {
                currentString.append(string.charAt(i));
            } else {
                method(currentString, string, alphabet, countOfLetters, i);
            }
        }

        for (int i = 0; i < alphabet.length(); i++) {
            currentString.append(alphabet.charAt(i));
            currentString.append(countOfLetters[i]);
        }

        return currentString;
    }

    private static void method(StringBuilder currentString, String string, StringBuilder alphabet, int[] countOfLetters, int i) {
        currentString.append(string.charAt(i));

        int length = currentString.length();
        int index = alphabet.indexOf(String.valueOf(string.charAt(i)));

        if (countOfLetters[index] < length) {
            countOfLetters[index] = length;
        }

        currentString.setLength(0);
    }


    public static void convertToNum(String numberString) {
        HashMap<String, Integer> numbersMap = new HashMap<>();
        populateNumbersMap(numbersMap);

        String[] words = numberString.split(" ");
        int result = 0;
        int currentNumber = 0;
        int previousNumber = 0;

        for (String word : words) {
            int value = numbersMap.get(word);

            if (value >= 100) {
                previousNumber = value;
                result *= previousNumber;
                currentNumber = 0;
            } else {
                currentNumber += value;
            }

            if (value > previousNumber) {
                result += currentNumber - previousNumber;
                currentNumber = 0;
            }

            previousNumber = value;
        }

        System.out.println(result + currentNumber);
    }

    public static void populateNumbersMap(HashMap<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
    }


    public static void uniqueSubstring(String string) {
        ArrayList<String> array = new ArrayList<>();
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (i + 1 >= string.length()) {
                value.append(string.charAt(i));
                array.add(String.valueOf(value));
                value.setLength(0);
                break;
            }

            if ((int) string.charAt(i) + 1 == (int) string.charAt(i + 1)) {
                value.append(string.charAt(i));
            } else if (!value.isEmpty()) {
                value.append(string.charAt(i));
                array.add(String.valueOf(value));
                value.setLength(0);
            }
        }

        String itog = "";

        for (String str : array) {
            if (str.length() > itog.length()) {
                itog = str;
            }
        }

        System.out.println(itog);
    }


    public static int shortestWay(int[][] array) {
        int result = 0;
        ArrayList<Integer> results = new ArrayList<>();
        getWay(array, 0, 0, result, results);

        int finalAnswer = results.get(0);

        for (int value : results) {
            if (finalAnswer > value) {
                finalAnswer = value;
            }
        }

        return finalAnswer;
    }

    private static void getWay(int[][] array, int right, int height, int result, ArrayList<Integer> results) {
        if (height == 2 && right == 2) {
            result += array[height][right];
            results.add(result);
            return;
        }

        if (right + 1 < array[height].length) {
            getWay(array, right + 1, height, result + array[height][right], results);
        }

        if (height + 1 < array.length) {
            getWay(array, right, height + 1, result + array[height][right], results);
        }
    }


    public static StringBuilder numericOrder(String string) {
        string = string.trim();

        int countOfWords = 1;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                countOfWords += 1;
            }
        }

        String[] arrayOfWords = new String[countOfWords];

        int startIndex = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ' || i == string.length() - 1) {
                String word = string.substring(startIndex, i + 1).trim();
                startIndex = i + 1;

                for (int y = 0; y < word.length(); y++) {
                    if (Character.isDigit(word.charAt(y))) {
                        arrayOfWords[Character.getNumericValue(word.charAt(y)) - 1] = word.replace(String.valueOf(word.charAt(y)), "") + " ";
                    }
                }
            }
        }

        StringBuilder finalString = new StringBuilder();

        for (String value : arrayOfWords) {
            finalString.append(value);
        }

        return finalString;
    }


    public static int switchNums(int firstNum, int secondNum) {
        char[] array = String.valueOf(firstNum).toCharArray();

        Integer[] numbers = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            numbers[i] = Character.getNumericValue(array[i]);
        }

        Comparator<Integer> descendingComparator = Comparator.reverseOrder();

        Arrays.sort(numbers, descendingComparator);

        StringBuilder firstNumStr = new StringBuilder();

        for (int value : numbers) {
            firstNumStr.append(value);
        }

        String secondNumStr = String.valueOf(secondNum);

        a: for (int i = 0; i < firstNumStr.length(); i++) {
            for (int y = 0; y < secondNumStr.length(); y++) {
                int value1 = Character.getNumericValue(firstNumStr.charAt(i));
                int value2 = Character.getNumericValue(secondNumStr.charAt(y));

                if (value1 > value2) {
                    secondNumStr = secondNumStr.replaceFirst(String.valueOf(secondNumStr.charAt(y)), String.valueOf(firstNumStr.charAt(i)));
                    continue a;
                }
            }
        }

        return Integer.parseInt(secondNumStr);
    }

}
