import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        //Задание 1:
        System.out.println("Задание 1:");
        //hiddenAnagram(new String[] {"My world evolves in a beautiful space called Tesh.", "sworn love lived"});
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        //Задание 2:
        System.out.println("\nЗадание 2:");
        collect("intercontinentalisationalism", 6);
        collect("strengths", 3);
        collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15);
        collect("pneumonoultramicroscopicsilicovolcanoconios", 15);

        //Задание 3:
        System.out.println("\nЗадание 3:");
        nicoCipher("myworldevolvesinhers", "tesh");
        nicoCipher("andiloveherso", "tesha");
        nicoCipher("mubashirhassan", "crazy");
        nicoCipher("edabitisamazing", "matt");
        nicoCipher("iloveher", "612345");

        //Задание 4:
        System.out.println("\nЗадание 4:");
        twoProduct(new int[]{1, 2, 9, 3, 4, 5, 15}, 45);
        twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45);
        twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20);
        twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        twoProduct(new int[]{100, 12, 4, 1, 2}, 15);

        //Задание 5:
        System.out.println("\nЗадание 5:");
        isExact(6);
        isExact(24);
        isExact(125);
        isExact(720);
        isExact(1024);
        isExact(40320);

        //Задание 6:
        System.out.println("\nЗадание 6:");
        fractions("0.(6)");
        fractions("1.(1)");
        fractions("3.(142857)");
        fractions("0.19(2367)");
        fractions("0.1097(3)");

        //Задание 7:
        System.out.println("\nЗадание 7:");
        pilish_string("33314444");
        pilish_string("TOP");
        pilish_string("X");
        pilish_string("");
        pilish_string("TOPASSSSS:)");

        //Задание 8:
        System.out.println("\nЗадание 8:");
        generateNonconsecutive("3 + 5 * (2 * (2 - 60 / 5))");
        generateNonconsecutive("3 + 5 * (2 - 6)");
        generateNonconsecutive("6 - 18 / (-1 + 4)");
        generateNonconsecutive("23 * 7 - 7 + 11");
        generateNonconsecutive("((150 - 45) / 5 + 30 - (12 - 1)) / 2 - 1");
        generateNonconsecutive("((150 - 45) / 5 + 30 - (12 - 1)) / 2 - 1 * (5 * 5) + 1 - 2");

        //Задание 9:
        System.out.println("\nЗадание 9:");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        //Задание 10:
        System.out.println("\nЗадание 10:");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));

    }


    public static String hiddenAnagram(String sentence, String word) {
        // Приводим обе строки к нижнему регистру и удаляем пробелы и знаки препинания
        String cleanSentence = sentence.toLowerCase().replaceAll("[^a-z]", "");
        String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");

        // Сортируем буквы второй строки
        char[] sortedWord = cleanWord.toCharArray();
        Arrays.sort(sortedWord);

        // Ищем скрытую анаграмму в первой строке
        int startIndex = 0;
        int endIndex = cleanWord.length() - 1;

        while (endIndex < cleanSentence.length()) {
            String substring = cleanSentence.substring(startIndex, endIndex + 1);
            char[] sortedSubstring = substring.toCharArray();
            Arrays.sort(sortedSubstring);

            // Проверяем, является ли подстрока анаграммой второй строки
            if (Arrays.equals(sortedWord, sortedSubstring)) {
                // Возвращаем найденную анаграмму
                return substring;
            }

            // Сдвигаем окно поиска вправо
            startIndex++;
            endIndex++;
        }

        // Если скрытая анаграмма не найдена, возвращаем "notfound"
        return "notfound";
    }


    public static void collect(String string, int step) {
        int maxSteps = string.length() / step;

        String[] result = new String[maxSteps];

        int startIndex = 0;
        int endIndex = step;

        for (int i = 0; i < maxSteps; i++) {
            result[i] = string.substring(startIndex, endIndex);
            startIndex += step;
            endIndex += step;
        }

        System.out.println(Arrays.deepToString(result));
    }


    public static void nicoCipher(String message, String key) {
        int[] sortedNumArray = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            sortedNumArray[i] = i + 1;
        }

        char[] keyCharArray = key.toCharArray();
        char[] sortedKeyCharArray = keyCharArray.clone();
        Arrays.sort(sortedKeyCharArray);

        int[] numArray = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (sortedKeyCharArray[i] == keyCharArray[j] && numArray[j] == '\0') {
                    numArray[j] = sortedNumArray[i];
                } else if (sortedKeyCharArray[i] == keyCharArray[j] && j < key.length() - 1) {
                    numArray[j + 1] = sortedNumArray[i];
                }
            }
        }

        char[][] messageArray = new char[(int) Math.ceil((double) message.length() / (double) key.length())][key.length()];

        int startIndex = 0;
        int endIndex = key.length();

        for (int i = 0; i <= message.length() / key.length(); i++) {
            if (message.length() - startIndex <= 0) {
                break;
            }

            if (message.length() - startIndex < key.length()) {
                String substring = message.substring(startIndex, message.length());

                for (int j = 0; j < substring.length(); j++) {
                    messageArray[i][j] = substring.charAt(j);
                }

                for (int k = 0; k < key.length(); k++) {
                    if (messageArray[i][k] == '\0') {
                        messageArray[i][k] = ' ';
                    }
                }

                break;
            }

            for (int j = 0; j < 1; j++) {
                String substring = message.substring(startIndex, endIndex);
                messageArray[i] = substring.toCharArray();
                startIndex += key.length();
                endIndex += key.length();
            }
        }

        char[][] sortedMessageArray = new char[(int) Math.ceil((double) message.length() / (double) key.length())][key.length()];

        for (int i = 0; i < messageArray.length; i++) {
            for (int j = 0; j < key.length(); j++) {
                for (int k = 0; k < key.length(); k++) {
                    if (sortedNumArray[j] == numArray[k]) {
                        sortedMessageArray[i][j] = messageArray[i][k];
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sortedMessageArray.length; i++) {
            for (char letter : sortedMessageArray[i]) {
                result.append(letter);
            }
        }

        System.out.println(result);
    }


    public static void twoProduct(int[] arr, int n) {
        int[] result = new int[2];

        a:
        for (int i = 0; i < arr.length; i++) {
            for (int s = i + 1; s < arr.length; s++) {
                if (arr[i] * arr[s] == n) {
                    result[0] = arr[i];
                    result[1] = arr[s];
                    break a;
                }
            }
        }

        if (result[0] != 0) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("[]");
        }
    }


    public static void isExact(int number) {
        System.out.println(Arrays.toString(checkFactorial(number, 1, 1)));
    }

    public static int[] checkFactorial(int number, int value, int step) {
        if (value == number) {
            int[] result = new int[2];
            result[0] = number;
            result[1] = step - 1;
            return result;
        }

        if (value > number) {
            return new int[0];
        }

        if (number > value) {
            return checkFactorial(number, value * step, step + 1);
        }

        return new int[0];
    }


    public static void fractions(String number) {
        String modifiedNumber = number.replaceAll("\\(|\\)", "");

        String valueInScopes = number.substring(number.indexOf('(') + 1, number.indexOf(')'));

        StringBuilder checkNumber = new StringBuilder();
        checkNumber.append(modifiedNumber);

        if (modifiedNumber.length() < 15) {
            while (checkNumber.length() < 15) {
                checkNumber.append(valueInScopes);
            }
        }

        checkNumber.setLength(15);

        double parsedNumber = Double.parseDouble(modifiedNumber);

        double denominator = 2.;

        while (true) {
            double numerator = Math.ceil(parsedNumber * denominator);

            DecimalFormat decimalFormat = new DecimalFormat("#.#############");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);

            if (decimalFormat.format(numerator / denominator).equals(checkNumber.toString().replace(".", ","))) {
                String result = (int) numerator + "/" + (int) denominator;
                System.out.println(result);
                break;
            }

            denominator++;
        }
    }

/*
    public static void pilish_string(String text) {
        String piNumber = "314159265358979";

        int length = text.length();

        StringBuilder result = new StringBuilder();

        int sumPiNumbers = 0;

        int spareI = 0;

        for (int i = 0; i < length; i++) {
            sumPiNumbers += Character.getNumericValue(piNumber.charAt(i));

            if (sumPiNumbers == length) {
                int startIndex = 0;
                int endIndex = 0;

                for (int j = 0; j <= i; j++) {
                    if (spareI != 0 && j == i) {
                        break;
                    }
                    endIndex += Character.getNumericValue(piNumber.charAt(j));

                    String substring = text.substring(startIndex, endIndex);
                    result.append(substring).append(" ");

                    startIndex += Character.getNumericValue(piNumber.charAt(j));
                }

                break;
            } else if (sumPiNumbers > length) {
                result.append(text);

                for (int j = result.length(); j < sumPiNumbers; j ++) {
                    result.append(result.charAt(result.length() - 1));
                }

                text = result.toString();
                result.setLength(0);

                if (text.length() == 3 || text.isEmpty()) {
                    System.out.println(text);
                    break;
                }

                sumPiNumbers -= Character.getNumericValue(piNumber.charAt(i));
                spareI += i - 1;
            }
        }

        System.out.println(result);
    }
}*/

    public static void pilish_string(String text) {
        String piNumber = "314159265358979";

        int length = text.length();

        StringBuilder result = new StringBuilder();

        int sumPiNumbers = 0;

        for (int i = 0; i < length; i++) {
            sumPiNumbers += Character.getNumericValue(piNumber.charAt(i));

            if (sumPiNumbers == length) {
                int startIndex = 0;
                int endIndex = 0;

                for (int j = 0; j <= i; j++) {
                    endIndex += Character.getNumericValue(piNumber.charAt(j));

                    String substring = text.substring(startIndex, endIndex);
                    result.append(substring).append(" ");

                    startIndex += Character.getNumericValue(piNumber.charAt(j));
                }

                break;
            } else if (sumPiNumbers > length) {
                result.append(text);

                for (int j = result.length(); j < sumPiNumbers; j++) {
                    result.append(result.charAt(result.length() - 1));
                }

                if (result.length() == 3 || result.isEmpty()) {
                    break;
                }

                text = result.toString();
                result.setLength(0);

                int startIndex = 0;
                int endIndex = 0;

                for (int j = 0; j <= i; j++) {
                    endIndex += Character.getNumericValue(piNumber.charAt(j));

                    String substring = text.substring(startIndex, endIndex);
                    result.append(substring).append(" ");

                    startIndex += Character.getNumericValue(piNumber.charAt(j));
                }

                break;
            }
        }

        System.out.println(result);
    }


    public static void generateNonconsecutive(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.replaceAll(" ", ""));
        System.out.println(stringBuilder);

        while (stringBuilder.indexOf("(") != -1) {
            int index = stringBuilder.lastIndexOf("(");
            int indexOfEndScope = 0;

            for (int i = index; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == ')') {
                    indexOfEndScope += i;
                    break;
                }
            }

            String slice = stringBuilder.substring(index + 1, indexOfEndScope);
            System.out.println(slice);

            ArrayList<String> array = new ArrayList();

            int startIndex = 0;

            for (int i = 1; i < slice.length(); i++) {
                if (slice.charAt(i) == '+' || slice.charAt(i) == '-' ||
                        slice.charAt(i) == '*' || slice.charAt(i) == '/') {

                    if ((slice.charAt(i - 1) == '*' || slice.charAt(i - 1) == '/') && slice.charAt(i) == '-') {
                        array.add(slice.substring(startIndex));
                        continue;
                    }

                    array.add(slice.substring(startIndex, i));
                    array.add(String.valueOf(slice.charAt(i)));

                    startIndex = i + 1;
                }
            }

            if ((slice.charAt(slice.length() - 3) == '*' || slice.charAt(slice.length() - 3) == '/') &&
                 slice.charAt(slice.length() - 2) == '-') {
            } else {
                array.add(slice.substring(startIndex));
            }

            ArrayList<String> arrayCalculated = new ArrayList<>(array);

            int calculate;

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals("*")) {
                    calculate = Integer.parseInt(array.get(i - 1)) * Integer.parseInt(array.get(i + 1));
                    arrayCalculated.set(i, String.valueOf(calculate));
                    arrayCalculated.remove(i - 1);
                    arrayCalculated.remove(i);
                    continue;
                }

                if (array.get(i).equals("/")) {
                    calculate = Integer.parseInt(array.get(i - 1)) / Integer.parseInt(array.get(i + 1));
                    arrayCalculated.set(i, String.valueOf(calculate));
                    arrayCalculated.remove(i - 1);
                    arrayCalculated.remove(i);
                }
            }

            array = arrayCalculated;

            int calculate2;

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).equals("-")) {
                    calculate2 = Integer.parseInt(array.get(i - 1)) - Integer.parseInt(array.get(i + 1));
                    arrayCalculated.set(i, String.valueOf(calculate2));
                    arrayCalculated.remove(i - 1);
                    arrayCalculated.remove(i);
                }
            }

            for (int i = 0; i < arrayCalculated.size(); i++) {
                if (arrayCalculated.get(i).equals("+")) {
                    calculate2 = Integer.parseInt(arrayCalculated.get(i - 1)) + Integer.parseInt(arrayCalculated.get(i + 1));
                    arrayCalculated.set(i, String.valueOf(calculate2));
                    arrayCalculated.remove(i - 1);
                    arrayCalculated.remove(i);
                }
            }

            System.out.println(arrayCalculated.get(0));

            stringBuilder.replace(index, indexOfEndScope + 1, arrayCalculated.get(0)); // .replace()
            System.out.println(stringBuilder);
        }

            //----------------------------------------------------------------------------

        String slice = stringBuilder.toString();

        ArrayList<String> array = new ArrayList();

        int startIndex = 0;

        for (int i = 1; i < slice.length(); i++) {
            if (slice.charAt(i) == '+' || slice.charAt(i) == '-' ||
                slice.charAt(i) == '*' || slice.charAt(i) == '/') {

                if ((slice.charAt(i - 1) == '*' || slice.charAt(i - 1) == '/') && slice.charAt(i) == '-') {
                    array.add(slice.substring(startIndex));
                    continue;
                }

                array.add(slice.substring(startIndex, i));
                array.add(String.valueOf(slice.charAt(i)));

                startIndex = i + 1;
            }
        }

        if ((slice.charAt(slice.length() - 3) == '*' || slice.charAt(slice.length() - 3) == '/') &&
             slice.charAt(slice.length() - 2) == '-') {
        } else {
            array.add(slice.substring(startIndex));
        }

        ArrayList<String> arrayCalculated = new ArrayList<>(array);

        int calculate;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals("*")) {
                calculate = Integer.parseInt(array.get(i - 1)) * Integer.parseInt(array.get(i + 1));
                arrayCalculated.set(i, String.valueOf(calculate));
                arrayCalculated.remove(i - 1);
                arrayCalculated.remove(i);
            }
        }

        for (int i = 0; i < arrayCalculated.size(); i++) {
            if (arrayCalculated.get(i).equals("/")) {
                calculate = Integer.parseInt(arrayCalculated.get(i - 1)) / Integer.parseInt(arrayCalculated.get(i + 1));
                arrayCalculated.set(i, String.valueOf(calculate));
                arrayCalculated.remove(i - 1);
                arrayCalculated.remove(i);
            }
        }

        array = arrayCalculated;

        int calculate2;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals("-")) {
                calculate2 = Integer.parseInt(array.get(i - 1)) - Integer.parseInt(array.get(i + 1));
                arrayCalculated.set(i, String.valueOf(calculate2));
                arrayCalculated.remove(i - 1);
                arrayCalculated.remove(i);
            }
        }

        for (int i = 0; i < arrayCalculated.size(); i++) {
            if (arrayCalculated.get(i).equals("+")) {
                calculate2 = Integer.parseInt(arrayCalculated.get(i - 1)) + Integer.parseInt(arrayCalculated.get(i + 1));
                arrayCalculated.set(i, String.valueOf(calculate2));
                arrayCalculated.remove(i - 1);
                arrayCalculated.remove(i);
            }
        }

        System.out.println(arrayCalculated.get(0));
        System.out.println("Это полный капееец.");
    }


    public static String isValid(String str) {
        int[] charCounts = new int[26];
        for (char c : str.toCharArray()) {
            charCounts[c - 'a']++;
        }
        int prevCount = -1;
        int removals = 0;
        for (int count : charCounts) {
            if (count > 0) {
                if (prevCount == -1) {
                    prevCount = count;
                } else if (prevCount != count) {
                    removals += Math.abs(prevCount - count);
                    if (removals > 1) return "NO";
                }
            }
        }
        return "YES";
    }


    public static String findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        StringBuilder lcs = new StringBuilder();

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = s1.length(), j = s2.length();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}

