import java.util.regex.*;
public class RegexPasswordValidation {
    public static void main(String[] args) {
        String password = "Test@1234";
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        boolean isValid = Pattern.matches(pattern, password);
        System.out.println("Is valid password: " + isValid);
    }
}