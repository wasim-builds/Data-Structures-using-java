import java.util.regex.*;
public class RegexDateValidation {
    public static void main(String[] args) {
        String date = "06/01/2026";
        String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        boolean isValid = Pattern.matches(pattern, date);
        System.out.println("Is valid date: " + isValid);
    }
}