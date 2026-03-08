import java.util.regex.*;
public class RegexEmailValidation {
    public static void main(String[] args) {
        String email = "test@example.com";
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isValid = Pattern.matches(pattern, email);
        System.out.println("Is valid email: " + isValid);
    }
}