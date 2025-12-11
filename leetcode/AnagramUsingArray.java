package leetcode;
import java.util.Scanner;

public class AnagramUsingArray {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();

        if (s1 != t1) {
            return false;
        }

        int arr[] = new int[26];

        // Count frequency of characters in 's'
        for (int i = 0; i < s1; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        // Subtract frequency based on 't'
        for (int i = 0; i < t1; i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // User input
            System.out.print("Enter first string: ");
            String s = scanner.nextLine().toLowerCase(); // Convert to lowercase for case insensitivity

            System.out.print("Enter second string: ");
            String t = scanner.nextLine().toLowerCase();

            // Checking for anagram
            AnagramUsingArray obj = new AnagramUsingArray();
            boolean result = obj.isAnagram(s, t);

            // Output result
            System.out.println("Are the strings anagrams? " + result);
        }
    }
}
