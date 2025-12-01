package Strings;

public class StringToInteger {

    /**
     * Converts a string to an integer without using the built-in Integer.parseInt().
     * This method handles whitespace, signs, and integer overflow.
     *
     * @param str The string to be converted.
     * @return The integer value of the string.
     */



    


    public int convert(String str) {
        // 1. Handle Null or Empty Input
        if (str == null || str.length() == 0) {
            System.out.println("DEBUG: Input string is null or empty. Returning 0.");
            return 0;
        }

        // 2. Trim Whitespace
        str = str.trim();
        if (str.isEmpty()) {
            System.out.println("DEBUG: String is empty after trimming whitespace. Returning 0.");
            return 0;
        }


        // 3. Handle Sign (+/-)
        int sign = 1;
        int i = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            i++;
        } else if (firstChar == '-') {
            sign = -1;
            i++;
        }

        long result = 0; // Use long to detect overflow before it happens

        // 4. Iterate and Convert Characters
        for (; i < str.length(); i++) {
            char c = str.charAt(i);

            // If a non-digit character is found, stop parsing.
            if (!Character.isDigit(c)) {
                 System.out.println("DEBUG: Non-digit character '" + c + "' found. Stopping parse.");
                 break;
            }

            int digitValue = c - '0'; // Convert char '5' to int 5
            result = result * 10 + digitValue;

            // 5. Check for Overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                System.out.println("DEBUG: Overflow detected. Clamping to Integer.MAX_VALUE.");
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                System.out.println("DEBUG: Underflow detected. Clamping to Integer.MIN_VALUE.");
                return Integer.MIN_VALUE;
            }
        }

        // Apply the sign to the final result
        result *= sign;

        return (int) result;
    }

    /**
     * Main method to test the string to integer conversion.
     */
    public static void main(String[] args) {
        StringToInteger converter = new StringToInteger();

        // --- Test Cases ---
        String[] testStrings = {
            "42",
            "   -42",
            "4193 with words",
            "words and 987",
            "-91283472332", // Exceeds integer range
            "2147483648",   // Exceeds Integer.MAX_VALUE
            "+1"
        };

        System.out.println("--- Running String to Integer Conversion Tests ---");
        for (String test : testStrings) {
            System.out.println("\nInput String: \"" + test + "\"");
            int result = converter.convert(test);
            System.out.println("Converted Integer: " + result);
        }
    }
}
