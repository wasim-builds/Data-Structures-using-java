package DataStructures.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Keyboard Row (LeetCode 500)
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<Set<Character>> sets = new ArrayList<>();
        
        for (String row : rows) {
            Set<Character> set = new HashSet<>();
            for (char c : row.toCharArray()) {
                set.add(c);
            }
            sets.add(set);
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int rowIdx = -1;
            for (int i = 0; i < 3; i++) {
                if (sets.get(i).contains(lower.charAt(0))) {
                    rowIdx = i;
                    break;
                }
            }
            
            boolean valid = true;
            for (char c : lower.toCharArray()) {
                if (!sets.get(rowIdx).contains(c)) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
