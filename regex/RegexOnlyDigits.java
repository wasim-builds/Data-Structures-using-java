import java.util.regex.*;
public class RegexOnlyDigits {
    public static void main(String[] args) {
        String input = "123456";
        String pattern = "\\d+";
        boolean isDigits = Pattern.matches(pattern, input);
        System.out.println("Contains only digits: " + isDigits);
    }
}