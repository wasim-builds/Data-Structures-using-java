import java.util.regex.*;
public class RegexWordsWithCapital {
    public static void main(String[] args) {
        String text = "Hello World, this Is Java.";
        String pattern = "\\b[A-Z][a-z]*\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            System.out.println("Word starting with capital: " + matcher.group());
        }
    }
}