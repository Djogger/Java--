import java.util.regex.*;

//Задание: 1

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price20.45 of the product is $19.99. It is 3times more 5 5.4 than -5 the previous price.";
        try {
            Pattern pattern = Pattern.compile("(-)?\\d+([.]\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректный синтаксис регулярного выражения: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Проверь последовательность методов: " + e.getMessage());
        }
    }
}
