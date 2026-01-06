import java.util.regex.*;
public class RegexPhoneNumbers {
    public static void main(String[] args) {
        String text = "Call me at 9876543210 or 0123456789.";
        String pattern = "\\b\\d{10}\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            System.out.println("Found phone number: " + matcher.group());
        }
    }
}