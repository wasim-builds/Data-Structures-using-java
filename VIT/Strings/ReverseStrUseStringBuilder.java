package Strings;
import java.util.Scanner;

public class ReverseStrUseStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String name = sc.nextLine();
        
        sc.close(); // Closing scanner after use
        
        String reversed = reverseString(name);
        System.out.println("Reversed string: " + reversed);
    }

    // Method to reverse a string using StringBuilder
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

