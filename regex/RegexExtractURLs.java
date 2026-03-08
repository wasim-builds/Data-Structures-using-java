import java.util.regex.*;
public class RegexExtractURLs {
    public static void main(String[] args) {
        String text = "Visit https://www.example.com and http://test.com.";
        String pattern = "https?://\\S+";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            System.out.println("Found URL: " + matcher.group());
        }
    }
}