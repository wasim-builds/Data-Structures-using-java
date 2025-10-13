package regexs;

import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {
        // Basic Pattern Matching
        String text = "Hello123 World";
        
        // Digit Check
        boolean hasDigits = Pattern.matches(".*\\d+.*", text);
        System.out.println("Contains digits: " + hasDigits);  // true

        // Email Validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        boolean isValidEmail = Pattern.matches(emailRegex, "user@example.com");
        System.out.println("Valid Email: " + isValidEmail);  // true

        // Phone Number Validation
        String phoneRegex = "^\\+?\\d{10,14}$";
        boolean isValidPhone = Pattern.matches(phoneRegex, "1234567890");
        System.out.println("Valid Phone: " + isValidPhone);  // true

        // Additional Regex Demonstrations
        demonstrateRegexMethods();
    }

    private static void demonstrateRegexMethods() {
        // Matching and Finding
        String text = "Java is awesome, Java is powerful";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(text);

        // Count occurrences
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Java appears " + count + " times");

        // Replace method
        String replacedText = text.replaceAll("Java", "Python");
        System.out.println("Replaced text: " + replacedText);

        // Split method
        String[] words = text.split("\\s+");
        System.out.println("Words split:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // More comprehensive email validation
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        if (email == null) {
            return false;
        }
        
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Phone number validation with more flexibility
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Allows optional + sign, 10-14 digits, with optional spaces
        String phoneRegex = "^\\+?[0-9\\s]{10,14}$";
        return phoneNumber.replaceAll("\\s", "").matches(phoneRegex);
    }
}
