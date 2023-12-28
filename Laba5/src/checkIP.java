import java.util.regex.*;

//Задание: 4

public class checkIP {
    public static void main(String[] args) {
        String text1 = "156.044.53AAAAA5.776";
        String text2 = "205.01.222.5";
        String text3 = "0.0.0.0";

        try {
            isValid(text2);
            System.out.println("IP корректен.");
        } catch (IllegalStateException e) {
            System.out.println("Проверь последовательность методов: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void isValid(String text) {
        try {
            String regex = "^((25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?|0)\\.){3}(25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?|0)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("Неверный IP");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректный синтаксис регулярного выражения: " + e.getMessage());
        }
    }
}
