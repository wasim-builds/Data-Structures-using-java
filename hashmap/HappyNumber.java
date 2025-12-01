import java.util.HashSet;
import java.util.Set;

/**
 * This class determines if a number is a "happy number".
 *
 * A happy number is a number which eventually reaches 1 when replaced by
 * the sum of the square of each digit.
 *
 * Example: 19
 * 1^2 + 9^2 = 1 + 81 = 82
 * 8^2 + 2^2 = 64 + 4 = 68
 * 6^2 + 8^2 = 36 + 64 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * -> 19 is a happy number.
 *
 * Example: 4
 * 4^2 = 16
 * 1^2 + 6^2 = 37
 * ...
 * 2^2 + 0^2 = 4
 * -> 4 is an unhappy number because it gets stuck in a cycle.
 */
public class HappyNumber {

    /**
     * Calculates the sum of the squares of the digits of a number.
     * e.g., getSumOfSquares(19) = 1*1 + 9*9 = 82
     *
     * @param n The number to process.
     * @return The sum of the squares of its digits.
     */
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            // Get the last digit using modulo
            int digit = n % 10;
            // Add its square to the sum
            sum += digit * digit;
            // Remove the last digit using integer division
            n = n / 10;
        }
        return sum;
    }

    /**
     * Checks if a number is a happy number.
     *
     * @param n The number to check.
     * @return true if the number is happy, false otherwise.
     */
    public static boolean isHappy(int n) {
        // Use a HashSet to store numbers we've already seen in the sequence.
        // This is how we detect a cycle.
        Set<Integer> seen = new HashSet<>();

        // Continue the process as long as n is not 1 (the happy number target)
        // and we haven't seen this number before (which would mean a cycle).
        while (n != 1 && !seen.contains(n)) {
            // Add the current number to the set of seen numbers.
            seen.add(n);
            
            // Calculate the next number in the sequence.
            n = getSumOfSquares(n);
        }

        // After the loop, if n is 1, it's a happy number.
        // If n is not 1, it means we broke the loop because we found a
        // number we had already seen, indicating an infinite (unhappy) cycle.
        return n == 1;
    }

    /**
     * Main method to test the isHappy function.
     */
    public static void main(String[] args) {
        // --- Diagnostic Print ---
        // Added this line to help debug the "Unresolved compilation problem".
        // If this line prints, the issue is likely in the lines below.
        // If it doesn't, the issue is likely with the file name or environment.
        System.out.println("Starting main method...");
        // --- End Diagnostic Print ---

        int num1 = 19;
        int num2 = 4;
        int num3 = 7; // Another happy number

        System.out.println("Is " + num1 + " a happy number? " + isHappy(num1)); // true
        System.out.println("Is " + num2 + " a happy number? " + isHappy(num2)); // false
        System.out.println("Is " + num3 + " a happy number? " + isHappy(num3)); // true
    }
}

