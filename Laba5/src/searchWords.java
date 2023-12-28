import java.util.regex.*;

//Задание: 5

public class searchWords {
    public static void main(String[] args) {
        String text = "why you bullying me? u cool man, why u bullying me, every one asking. Likvid asking you. why u bulling, sympathetic person? WHYYYYYYYY!?";
        char letter = 'w';

        searchWordsStartingWithLetter(text, letter);
    }

    public static void searchWordsStartingWithLetter(String text, char letter) {
        try {
            String pattern = "\\b" + letter + "\\w+\\b";

            Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = regex.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректный синтаксис регулярного выражения: " + e.getMessage());
        }
    }
}

// Доделать 4 задание и в 5 сделать поиск без учета регистра.