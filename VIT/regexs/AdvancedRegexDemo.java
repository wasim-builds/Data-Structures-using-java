package regexs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedRegexDemo {
    public static void main(String[] args) {
        // Text to work with
        String text = "Java is awesome, Java is powerful";
        
        // Find and Replace
        String replaced = text.replaceAll("Java", "Python");
        System.out.println("Replaced Text: " + replaced);

        // Split by Pattern
        String[] words = text.split("\\s+");
        System.out.println("\nWords in the text:");
        for (String word : words) {
            System.out.println(word);
        }

        // Pattern Matching with Regex Groups
        Pattern pattern = Pattern.compile("(\\w+)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("\nPattern Matching Groups:");
        while (matcher.find()) {
            System.out.println("Full Match: " + matcher.group(0));
            System.out.println("Group 1: " + matcher.group(1));
            System.out.println("Group 2: " + matcher.group(2));
            System.out.println("---");
        }

        // Additional Regex Demonstrations
        demonstrateRegexValidation();
    }

    private static void demonstrateRegexValidation() {
        // Email Validation
        String[] emails = {
            "user@example.com",
            "john.doe@company.co.uk",
            "invalid-email",
            "user@.com"
        };

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        System.out.println("\nEmail Validation:");
        for (String email : emails) {
            boolean isValid = email.matches(emailRegex);
            System.out.println(email + " is valid: " + isValid);
        }

        // Phone Number Validation
        String[] phoneNumbers = {
            "+1234567890",
            "1234567890",
            "+44 20 7123 4567",
            "123"
        };

        String phoneRegex = "^\\+?[0-9]{10,14}$";
        
        System.out.println("\nPhone Number Validation:");
        for (String phone : phoneNumbers) {
            boolean isValid = phone.replaceAll("\\s", "").matches(phoneRegex);
            System.out.println(phone + " is valid: " + isValid);
        }
    }

    // Utility method for complex regex matching
    public static boolean matchPattern(String text, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
