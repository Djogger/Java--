import java.util.regex.*;

//Задание: 2

public class checkPassword {
    public static void main(String[] args) {
        String text = "sdkHGH16mm204";
        try {
            validatePassword(text);
            System.out.println("Пароль корректен!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Проверь последовательность методов: " + e.getMessage());
        }
    }

    public static void validatePassword(String password) {
        try {
            String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("Пароль не соответствует требованиям.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректный синтаксис регулярного выражения: " + e.getMessage());
        }
    }
}
