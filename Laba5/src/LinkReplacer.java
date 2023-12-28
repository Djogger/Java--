import java.util.regex.*;

//Задание: 3

public class LinkReplacer {
    public static void main(String[] args) {
        String text = "Ссылка 1: http://chirrup.ru, " +
                "Ссылка 2: https://www.blablabla.com";

        try {
        String regex = "(http|https)://[\\w.-]+(/[\\w-./?%&=]*)?";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("<a href=$0>$0</a>");
            System.out.println(result);
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректный синтаксис регулярного выражения: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Проверь последовательность методов: " + e.getMessage());
        }
    }
}