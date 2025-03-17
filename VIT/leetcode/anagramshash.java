package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class anagramshash {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        Map<Character, Integer> map = new HashMap<>();

        if (s1 != t1) {
            return false;
        }

        for (int i = 0; i < s1; i++) {
            Character sc = s.charAt(i);
            Character st = t.charAt(i);
            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(st, map.getOrDefault(st, 0) - 1);
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter first string: ");
        String s = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String t = scanner.nextLine();
        
        scanner.close();

        // Checking for anagram
        anagramshash obj = new anagramshash();
        boolean result = obj.isAnagram(s, t);

        // Output result
        System.out.println("Are the strings anagrams? " + result);
    }
}
