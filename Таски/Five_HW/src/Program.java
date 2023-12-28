import java.util.*;

public class Program {
    public static void main(String[] args) {
    // Задание 1:
        System.out.println("\nЗадание 1:");
        sameLetterPattern("ABAB", "CDCD");
        sameLetterPattern("ABCBA", "BCDCB");
        sameLetterPattern("FFGG", "CDCD");
        sameLetterPattern("FFFF", "ABCD");

    // Задание 2:
        System.out.println("\nЗадание 2:");
        spiderVsFly("H3", "E2");
        spiderVsFly("A4", "B2");
        spiderVsFly("A4", "C2");

    // Задание 3:
        System.out.println("\nЗадание 3:");
        digitsCount(4666);
        digitsCount(544);
        digitsCount(121317);
        digitsCount(0);
        digitsCount(12345);
        digitsCount(1289396387328L);

    // Задание 4:
        System.out.println("\nЗадание 4:");
        totalPoints(new String[] {"cat", "create", "sat"}, "caster");
        totalPoints(new String[] {"trance", "recant"}, "recant");
        totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed");

    // Задание 5:
        System.out.println("\nЗадание 5:");
        sumsUp(new int[] {1, 2, 3, 4, 5});
        sumsUp(new int[] {1, 2, 3, 7, 9});
        sumsUp(new int[] {10, 9, 7, 2, 8});
        sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7});

    // Задание 6:
        System.out.println("\nЗадание 6:");
        String[] scores1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        takeDownAverage(scores1);

        String[] scores2 = {"10%"};
        takeDownAverage(scores2);

        String[] scores3 = {"53%", "79%"};
        takeDownAverage(scores3);

    // Задание 7:
        System.out.println("\nЗадание 7:");
        caesarCipher("encode", "hello world", 3);
        caesarCipher("decode", "EPQSWX PEWX XEWO!", 4);

    // Задание 8:
        System.out.println("\nЗадание 8:");
        setSetup(5, 3);
        setSetup(7, 3);

    // Задание 9:
        System.out.println("\nЗадание 9:");
        timeDifference("Los Angeles", new StringBuilder("April 1, 2011 23:23"), "Canberra");
        timeDifference("London", new StringBuilder("July 31, 1983 23:01"), "Rome");
        timeDifference("New York", new StringBuilder("December 31, 1970 13:40"), "Beijing");
        timeDifference("New York", new StringBuilder("June 29, 1970 13:40"), "Beijing");
        timeDifference("New York", new StringBuilder("February 27, 1970 13:40"), "Beijing");

    // Задание 10:
        System.out.println("\nЗадание 10:");
        isNew(3);
        isNew(30);
        isNew(321);
        isNew(123);

    }


    public static void sameLetterPattern(String a, String b) {
        if (a.length() % 2 == 0) {
            int[] hashA = new int[a.length() / 2];
            int[] hashB = new int[b.length() / 2];

            char[] lettersA = a.toCharArray();
            char[] lettersB = b.toCharArray();

            int index = 0;

            for (int i = 1; i < a.length(); i += 2) {
                char letterA1 = lettersA[i];
                char letterA2 = lettersA[i-1];

                hashA[index] = Character.getNumericValue(letterA1) - Character.getNumericValue(letterA2);

                char letterB1 = lettersB[i];
                char letterB2 = lettersB[i-1];

                hashB[index] = Character.getNumericValue(letterB1) - Character.getNumericValue(letterB2);

                index++;
            }

            if (Arrays.equals(hashA, hashB)) {
                System.out.println(true);
                System.out.println(Arrays.toString(hashA));
                System.out.println(Arrays.toString(hashB));
            } else {
                System.out.println(false);
                System.out.println(Arrays.toString(hashA));
                System.out.println(Arrays.toString(hashB));
            }
        } else {
            int[] hashA = new int[a.length() - 1];
            int[] hashB = new int[b.length() - 1];

            char[] lettersA = a.toCharArray();
            char[] lettersB = b.toCharArray();

            int index = 0;

            for (int i = 1; i < a.length(); i++) {
                char letterA1 = lettersA[i];
                char letterA2 = lettersA[i-1];

                hashA[index] = Character.getNumericValue(letterA1) - Character.getNumericValue(letterA2);

                char letterB1 = lettersB[i];
                char letterB2 = lettersB[i-1];

                hashB[index] = Character.getNumericValue(letterB1) - Character.getNumericValue(letterB2);

                index++;
            }

            if (Arrays.equals(hashA, hashB)) {
                System.out.println(true);
                System.out.println(Arrays.toString(hashA));
                System.out.println(Arrays.toString(hashB));
            } else {
                System.out.println(false);
                System.out.println(Arrays.toString(hashA));
                System.out.println(Arrays.toString(hashB));
            }
        }
    }


    public static void spiderVsFly(String coordinationStart, String coordinationEnd) {
        StringBuilder arrayOfRadians = new StringBuilder("ABCDEFGH");

        Hashtable<Character, Character> letters = new Hashtable<>();
        letters.put('A', 'E');
        letters.put('B', 'F');
        letters.put('C', 'G');
        letters.put('D', 'H');
        letters.put('E', 'A');
        letters.put('F', 'B');
        letters.put('G', 'C');
        letters.put('H', 'D');

        char[] charsStart = coordinationStart.toCharArray();
        char[] charsEnd = coordinationEnd.toCharArray();

        int index = arrayOfRadians.indexOf(String.valueOf(charsStart[0]));

        // Пусть x = 5, (」°ロ°)」ЭТО НЕВАЖНО!!!!!
        double x = 5.; // это длина радианы до первой ломанной-круговой магистрали.
        double b = 0.7654 * x;// это путь между соседними радианами.

        StringBuilder result = new StringBuilder();
        result.append(charsStart[0]).append(charsStart[1]);

        ArrayList<StringBuilder> paths = new ArrayList<>();

        ArrayList<Double> length = new ArrayList<>();

        calculateFunction(x, b, arrayOfRadians, letters, charsStart, charsEnd, index, result, 0, "", paths, length);

        double value = Double.MAX_VALUE;

        for (int i = 0; i < paths.size(); i++) {
            if (value > length.get(i)) {
                value = length.get(i);
            }
        }

        int indexForPath = length.indexOf(value);

        StringBuilder theLowestPath = paths.get(indexForPath);

        System.out.println("Answer: " + theLowestPath);
        System.out.println("Length: " + value);
        System.out.println(" ");

        /*for (StringBuilder path : paths) {
            System.out.println(path);
        }*/
    }

    public static void calculateFunction(double x, double b, StringBuilder arrayOfRadians, Hashtable letters, char[] charsStart, char[] charsEnd, int index, StringBuilder result, double S, String move, ArrayList<StringBuilder> paths, ArrayList<Double> length) {
        if (charsStart[1] == charsEnd[1] && charsStart[0] == charsEnd[0]) {
            StringBuilder copiedResult = new StringBuilder();
            copiedResult.append(result);

            paths.add(copiedResult);
            length.add(S);

            return;
        }

        if (Integer.parseInt(String.valueOf(charsStart[1])) == 0) {
            StringBuilder copiedResult = new StringBuilder();
            copiedResult.append(result);

            for (int i = 0; i < Integer.parseInt(String.valueOf(charsEnd[1])); i++) {
                charsStart[1] += 1;
                copiedResult.append(charsEnd[0]).append(charsStart[1]);
                S += x;
            }

            paths.add(copiedResult);
            length.add(S);

            return;
        }

        if (letters.get(charsStart[0]).equals(charsEnd[0])) {
            StringBuilder copiedResult = new StringBuilder();
            copiedResult.append(result);

            for (int i = 0; i < Integer.parseInt(String.valueOf(charsStart[1])) + 1; i++) {
                charsStart[1] -= 1;
                copiedResult.append(arrayOfRadians.charAt(index)).append(charsStart[1]);
                S += x;
            }

            for (int i = 0; i < Integer.parseInt(String.valueOf(charsEnd[1])); i++) {
                charsStart[1] += 1;
                copiedResult.append("-").append(charsEnd[0]).append(charsStart[1]);
                S += x;
            }

            paths.add(copiedResult);
            length.add(S);

            return;
        }

        if (charsStart[0] == charsEnd[0] && charsStart[1] < charsEnd[1]) {
            StringBuilder copiedResult = new StringBuilder();
            copiedResult.append(result);

            for (int i = 0; i <= Integer.parseInt(String.valueOf(charsEnd[1])) - Integer.parseInt(String.valueOf(charsStart[1])); i++) {
                charsStart[1] += 1;
                copiedResult.append(arrayOfRadians.charAt(index)).append(charsStart[1]);
                S += x;
            }

            paths.add(copiedResult);
            length.add(S);

            return;
        }

        if (charsStart[0] == charsEnd[0]) {
            StringBuilder copiedResult = new StringBuilder();
            copiedResult.append(result);

            for (int i = 0; i <= Integer.parseInt(String.valueOf(charsStart[1])) - Integer.parseInt(String.valueOf(charsEnd[1])); i++) {
                charsStart[1] -= 1;
                copiedResult.append(arrayOfRadians.charAt(index)).append(charsStart[1]);
                S += x;
            }

            paths.add(copiedResult);
            length.add(S);

            return;
        }

        if (index + 1 <= arrayOfRadians.length() - 1 && (move.equals("right") || move.isEmpty()) && arrayOfRadians.indexOf(String.valueOf(charsEnd[0])) - arrayOfRadians.indexOf(String.valueOf(charsStart[0])) < 4  && b * (Double.parseDouble(String.valueOf(charsStart[1])) - 1) < x) {
            StringBuilder copiedResult = new StringBuilder(result);
            move = "";
            char[] copyArray = Arrays.copyOf(charsStart, charsStart.length);
            copyArray[0] = arrayOfRadians.charAt(index + 1);
            calculateFunction(x, b, arrayOfRadians, letters, copyArray, charsEnd, index + 1, copiedResult.append(arrayOfRadians.charAt(index + 1)).append(copyArray[1]), S + b * Double.parseDouble(String.valueOf(copyArray[1])), "right", paths, length);
        }

        if (index - 1 >= 0 && (move.equals("left") || move.isEmpty()) && arrayOfRadians.indexOf(String.valueOf(charsEnd[0])) - arrayOfRadians.indexOf(String.valueOf(charsStart[0])) >= 4  && b * (Double.parseDouble(String.valueOf(charsStart[1])) - 1) < x) {
            StringBuilder copiedResult = new StringBuilder(result);
            move = "";
            char[] copyArray = Arrays.copyOf(charsStart, charsStart.length);
            copyArray[0] = arrayOfRadians.charAt(index - 1);
            calculateFunction(x, b, arrayOfRadians, letters, copyArray, charsEnd, index - 1, copiedResult.append(arrayOfRadians.charAt(index - 1)).append(copyArray[1]), S + b * Double.parseDouble(String.valueOf(copyArray[1])), "left", paths, length);
        }

        if (Integer.parseInt(String.valueOf(charsStart[1])) - 1 >= 0) {
            StringBuilder copiedResult = new StringBuilder(result);
            char[] copyArray = Arrays.copyOf(charsStart, charsStart.length);
            copyArray[1] = (char) (copyArray[1] - 1);
            calculateFunction(x, b, arrayOfRadians, letters, copyArray, charsEnd, index, copiedResult.append(arrayOfRadians.charAt(index)).append(copyArray[1]), S + x, move, paths, length);
        }

        if (index + 1 > arrayOfRadians.length() - 1 && (move.equals("right") || move.isEmpty()) && arrayOfRadians.indexOf(String.valueOf(charsEnd[0])) - arrayOfRadians.indexOf(String.valueOf(charsStart[0])) < 4  && b * (Double.parseDouble(String.valueOf(charsStart[1])) - 1) < x) {
            StringBuilder copiedResult = new StringBuilder(result);
            move = "";
            char[] copyArray = Arrays.copyOf(charsStart, charsStart.length);
            copyArray[0] = arrayOfRadians.charAt(0);
            calculateFunction(x, b, arrayOfRadians, letters, copyArray, charsEnd, 0, copiedResult.append(arrayOfRadians.charAt(0)).append(copyArray[1]), S + b * Double.parseDouble(String.valueOf(copyArray[1])), "right", paths, length);
        }

        if (index - 1 < 0 && (move.equals("left") || move.isEmpty()) && arrayOfRadians.indexOf(String.valueOf(charsEnd[0])) - arrayOfRadians.indexOf(String.valueOf(charsStart[0])) >= 4 && b * (Double.parseDouble(String.valueOf(charsStart[1])) - 1) < x) {
            StringBuilder copiedResult = new StringBuilder(result);
            move = "";
            char[] copyArray = Arrays.copyOf(charsStart, charsStart.length);
            copyArray[0] = arrayOfRadians.charAt(arrayOfRadians.length() - 1);
            calculateFunction(x, b, arrayOfRadians, letters, copyArray, charsEnd, arrayOfRadians.length() - 1, copiedResult.append(arrayOfRadians.charAt(arrayOfRadians.length() - 1)).append(copyArray[1]), S + b * Double.parseDouble(String.valueOf(copyArray[1])), "left", paths, length);
        }
    }


        /*
        if (charsStart[0] == charsEnd[0] && charsStart[1] == charsEnd[1]) {
            System.out.println("ASS");
            return result;
        }


        if (index + 1 > arrayOfRadians.length() - 1 && step != 6) {
            System.out.println(".");
            charsStart[0] = arrayOfRadians.charAt(0);
            return calculateFunction(x, b, arrayOfRadians, charsStart, charsEnd, 0, result.append(arrayOfRadians.charAt(0)).append(charsStart[1]), step+1, S + b * x * charsStart[1]);
        }

        if (index - 1 < 0 && step != 6) {
            charsStart[0] = arrayOfRadians.charAt(arrayOfRadians.length() - 1);
            return calculateFunction(x, b, arrayOfRadians, charsStart, charsEnd, arrayOfRadians.length() - 1, result.append(arrayOfRadians.charAt(arrayOfRadians.length() - 1)).append(charsStart[1]), step+1, S + b * x * charsStart[1]);
        }

        if (index + 1 <= arrayOfRadians.length() - 1 && step != 6) {
            charsStart[0] = arrayOfRadians.charAt(index + 1);
            return calculateFunction(x, b, arrayOfRadians, charsStart, charsEnd, index + 1, result.append(charsStart), step + 1, S + b * x * charsStart[1]);
        }

        if (index - 1 >= 0 && step != 6) {
            charsStart[0] = arrayOfRadians.charAt(index - 1);
            calculateFunction(x, b, arrayOfRadians, charsStart, charsEnd, index - 1, result.append(charsStart), step + 1, S + b * x * charsStart[1]);
        }


        System.out.println(result);
        if (step <= 6) {
            charsStart[1] = (char) (charsStart[1] - 1);
            calculateFunction(x, b, arrayOfRadians, charsStart, charsEnd, index, result.append(charsStart), 0, S + x);
        }
*/


    public static void digitsCount(long num) {
        calculate(num, 0);
    }

    public static void calculate(long num, int count) {
        if (num / 10 == 0) {
            count++;
            System.out.println(count);
        } else {
            num = num / 10;
            count++;
            calculate(num, count);
        }
    }


    public static void totalPoints(String[] array, String str) {
        ArrayList<String> finalWords = new ArrayList<>();

        a: for (String word : array) {
            char[] charsAnswer = word.toCharArray();

            for (int i = 0; i < word.length(); i++) {
                int countW = word.length() - word.replace(String.valueOf(charsAnswer[i]), "").length();
                int countS = str.length() - str.replace(String.valueOf(charsAnswer[i]), "").length();

                if (str.contains(String.valueOf(charsAnswer[i])) && (countW == countS || countW < countS)) {
                    if (i == word.length() - 1) {
                        finalWords.add(word);
                    }
                } else continue a;
            }
        }

        Hashtable<Integer, Integer> tableOfPoints = new Hashtable<>();
        tableOfPoints.put(3, 1);
        tableOfPoints.put(4, 2);
        tableOfPoints.put(5, 3);
        tableOfPoints.put(6, 54);

        int countOfPoints = 0;

        for (String word : finalWords) {
            countOfPoints += tableOfPoints.get(word.length());
        }
        System.out.println(finalWords);
        System.out.println(countOfPoints);
    }


    public static void sumsUp(int[] array) {
        ArrayList<String> pare = new ArrayList<>();

        int i = 0;

        for (int num1 : array) {
            i++;
            for (int a = i; a < array.length; a++) {
                if (num1 != array[a] && num1 + array[a] == 8) {
                    int[] arrayForPare = new int[2];
                    arrayForPare[0] = num1;
                    arrayForPare[1] = array[a];

                    Arrays.sort(arrayForPare);

                    pare.add(Arrays.toString(arrayForPare));
                }
            }
        }

        System.out.println(pare);
    }


    public static void takeDownAverage(String[] scores) {
        double totalScore = 0;
        double count = scores.length;

        // Вычисляем сумму оценок и преобразуем проценты в числовое значение
        for (String score : scores) {
            double numericScore = Integer.parseInt(score.substring(0, score.length() - 1));
            totalScore += numericScore;
        }

        double mediumPoint = totalScore / count - 5;

        double x = mediumPoint * (count + 1);

        double answer = x - totalScore;

        System.out.println((int) answer + "%");
    }


    public static void caesarCipher(String typeWork, String str, int step) {
        StringBuilder alphabet = new StringBuilder();
        alphabet.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        str = str.toUpperCase();

        StringBuilder strBuild = new StringBuilder();
        strBuild.append(str);

        if (typeWork.equals("encode")) {
            for (int i = 0; i < str.length(); i++) {
                int index = alphabet.indexOf(String.valueOf(strBuild.charAt(i)));

                if (index == -1) {
                    continue;
                }

                char letter = alphabet.charAt(index + step);

                strBuild.setCharAt(i, letter);
            }
        } else if (typeWork.equals("decode")) {
            for (int i = 0; i < str.length(); i++) {
                int index = alphabet.indexOf(String.valueOf(strBuild.charAt(i)));

                if (index == -1) {
                    continue;
                }

                char letter = alphabet.charAt(index - step);

                strBuild.setCharAt(i, letter);
            }
        }

        System.out.println(strBuild);
    }


    public static void setSetup(int n, int k) {
        int factorialN = 1;
        int factorialZnamenatel = 0;

        for (int i = 2; i <= n; i++) {
            factorialN *= i;

            if (i == n - k) {
                factorialZnamenatel += factorialN;
            }
        }

        System.out.println(factorialN / factorialZnamenatel);
    }


    public static void timeDifference(String cityA, StringBuilder timeA, String cityB) {
        HashMap<String, Integer> hashTableMonths = new HashMap<>();
        hashTableMonths.put("January", 1);
        hashTableMonths.put("February", 2);
        hashTableMonths.put("March", 3);
        hashTableMonths.put("April", 4);
        hashTableMonths.put("May", 5);
        hashTableMonths.put("June", 6);
        hashTableMonths.put("July", 7);
        hashTableMonths.put("August", 8);
        hashTableMonths.put("September", 9);
        hashTableMonths.put("October", 10);
        hashTableMonths.put("November", 11);
        hashTableMonths.put("December", 12);

        HashMap<String, Double> hashTable = new HashMap<>();
        hashTable.put("Los Angeles", 8.);
        hashTable.put("New York", 5.);
        hashTable.put("Caracas", 4.3);
        hashTable.put("Buenos Aires", 3.);
        hashTable.put("London", 0.);
        hashTable.put("Rome", 1.);
        hashTable.put("Moscow", 3.);
        hashTable.put("Tehran", 3.3);
        hashTable.put("New Delhi", 5.3);
        hashTable.put("Beijing", 8.);
        hashTable.put("Canberra", 10.);

        double timeShift = hashTable.get(cityA) + hashTable.get(cityB);

        StringBuilder month = new StringBuilder(timeA.toString());
        String currentMonth = month.delete(month.indexOf(" "), month.length()).toString();

        StringBuilder year = new StringBuilder(timeA.toString());
        int coma = year.indexOf(",");
        int indexSpaceY1 = year.indexOf(" ", coma);
        year.delete(0, indexSpaceY1 + 1);
        int indexSpaceY2 = year.indexOf(" ");
        year.delete(indexSpaceY2, year.length());
        int currentYear = Integer.valueOf(String.valueOf(year));

        StringBuilder currentTime = new StringBuilder(timeA.toString());
        currentTime.delete(0, timeA.length() - 5);
        double currentTimeD = Double.valueOf(String.valueOf(currentTime.replace(2, 3, ".")));

        int indexSpace = timeA.indexOf(" ");
        timeA.delete(0, indexSpace + 1);
        int indexComa = timeA.indexOf(",");
        timeA.delete(indexComa, timeA.length());
        int day = Integer.valueOf(String.valueOf(timeA));

        int numberOfMonth = hashTableMonths.get(currentMonth);

        for (int i = 0; i < timeShift; i++) {
            currentTimeD++;

            if (day + 1 >= 31 || (currentMonth.equals("February") && day + 1 >= 28) || ((currentMonth.equals("April") ||
                    currentMonth.equals("June") || currentMonth.equals("September") || currentMonth.equals("November")) && day + 1 >= 30)) {
                if (numberOfMonth + 1 > 12) {
                    numberOfMonth -= 12;
                }

                numberOfMonth++;

                day = 0;
            }

            if (currentTimeD >= 24.) {
                currentTimeD -= 24.;

                day++;
            }
        }

        currentTime.setLength(0);
        currentTime.append(Math.round(currentTimeD * 100) / 100.0).replace(currentTime.indexOf("."), currentTime.indexOf(".") + 1, ":");

        if (currentTime.length() == 4) {
            currentTime.replace(0, 0, "0");
        } else if(currentTime.length() == 3) {
            currentTime.replace(0, 0, "0");
            currentTime.replace(currentTime.length(), currentTime.length(), "0");
        }

        String result = currentYear + "-" + numberOfMonth + "-" + day + " " + currentTime;

        System.out.println(result);
    }


    public static void isNew(int number) {
        String strNumber = String.valueOf(number);

        char[] array = strNumber.toCharArray();

        boolean truth = false;

        int checkNull = 0;

        for (int i = 1; i < array.length; i++) {
            checkNull += Integer.parseInt(String.valueOf(array[i]));
        }

        if (array.length == 1 || checkNull == 0) {
            truth = true;
            System.out.println(truth);
            return;
        }

        for (int i = 1; i < array.length; i++) {
            if ((int) array[0] < (int) array[i]) {
                truth = true;
                break;
            }
        }

        System.out.println(truth);
    }
}

