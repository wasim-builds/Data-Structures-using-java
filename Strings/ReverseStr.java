package Strings;
import java.util.Scanner;

public class ReverseStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String name = sc.nextLine();
        
        sc.close(); // Closing scanner after use
        
        String reversed = reverseString(name);
        System.out.println("Reversed string: " + reversed);
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        int n = str.length();
        String rev = "";
        
        for (int i = n - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        
        return rev;
    }
}
