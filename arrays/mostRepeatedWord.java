package arrays;

// Most repeated character in a word


import java.util.*;

public class mostRepeatedWord {

    // Function to find and print the word with the most repeated letters
    public static void mostRepeatedWords(String s) {
        String[] words = s.split(" "); // Split the sentence into words
        int maxRepeatCount = 0;
        List<String> resultWords = new ArrayList<>();

        for (String word : words) {
            Map<Character, Integer> freq = new HashMap<>();

            // Count the frequency of each character in the word
            for (char ch : word.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            // Count how many characters repeat in the word
            int repeatCount = 0;
            for (int count : freq.values()) {
                if (count > 1) {
                    repeatCount++;
                }
            }

            // Update result if current word has more repeated letters
            if (repeatCount > maxRepeatCount) {
                maxRepeatCount = repeatCount;
                resultWords.clear();
                resultWords.add(word);
            } else if (repeatCount == maxRepeatCount && repeatCount > 0) {
                resultWords.add(word);
            }
        }

        // If no word has repeated characters, print the first word
        if (maxRepeatCount == 0) {
            System.out.println(words[0]);
        } else {
            for (String word : resultWords) {
                System.out.print(word + " ");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Sample Inputs
        mostRepeatedWords("hello world");      // Output: hello
        mostRepeatedWords("this is a test");   // Output: test
        mostRepeatedWords("ab abcd aabbb");    // Output: aabbb
        mostRepeatedWords("abc def ghi");      // Output: abc
        mostRepeatedWords("zebra zoo apple");  // Output: zoo
    }
}

