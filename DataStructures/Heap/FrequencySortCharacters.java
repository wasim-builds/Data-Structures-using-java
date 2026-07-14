import java.util.*;

/**
 * Frequency Sort of Characters
 * 
 * Problem: Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 * 
 * Example 1:
 * Input: s = "tree"
 * Output: "eert" or "eetr"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * 
 * Example 2:
 * Input: s = "cccaaa"
 * Output: "aaaccc" or "cccaaa"
 * 
 * Example 3:
 * Input: s = "Aabb"
 * Output: "bbAa" or "bbaA"
 * 
 * Approach: Use Max Heap based on frequency
 * 1. Count frequency of each character using HashMap
 * 2. Add all characters to max heap sorted by frequency
 * 3. Build result string by extracting from heap
 * 
 * Time Complexity: O(n log n) where n is number of unique characters
 * Space Complexity: O(n)
 */
public class FrequencySortCharacters {
    
    /**
     * Character with frequency
     */
    static class CharFreq {
        char character;
        int frequency;
        
        public CharFreq(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
    
    /**
     * Sort characters by frequency using max heap
     */
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // Count frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Max heap based on frequency
        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>(
            (a, b) -> b.frequency - a.frequency
        );
        
        // Add all characters to heap
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new CharFreq(entry.getKey(), entry.getValue()));
        }
        
        // Build result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            CharFreq cf = maxHeap.poll();
            for (int i = 0; i < cf.frequency; i++) {
                result.append(cf.character);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Alternative using Map.Entry directly
     */
    public static String frequencySortSimple(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        maxHeap.addAll(map.entrySet());
        
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        
        return result.toString();
    }
    
    /**
     * Using Bucket Sort (O(n) time)
     */
    public static String frequencySortBucket(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // Count frequencies
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Create buckets
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Place characters in buckets based on frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        // Build result from highest frequency to lowest
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
    
    /**
     * Using TreeMap for sorting
     */
    public static String frequencySortTreeMap(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // TreeMap sorted by frequency (descending)
        TreeMap<Integer, List<Character>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            sortedMap.putIfAbsent(freq, new ArrayList<>());
            sortedMap.get(freq).add(entry.getKey());
        }
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : sortedMap.entrySet()) {
            int freq = entry.getKey();
            for (char c : entry.getValue()) {
                for (int i = 0; i < freq; i++) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
    
    /**
     * With detailed output
     */
    public static String frequencySortWithDetails(String s) {
        System.out.println("Input string: \"" + s + "\"");
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        System.out.println("Character frequencies:");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("  '" + entry.getKey() + "': " + entry.getValue());
        }
        
        String result = frequencySort(s);
        System.out.println("Result: \"" + result + "\"");
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        String s1 = "tree";
        System.out.println("=== Test Case 1 ===");
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: \"" + frequencySort(s1) + "\"");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2
        String s2 = "cccaaa";
        System.out.println("=== Test Case 2 ===");
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: \"" + frequencySort(s2) + "\"");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3
        String s3 = "Aabb";
        System.out.println("=== Test Case 3 ===");
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: \"" + frequencySort(s3) + "\"");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 4 with details
        String s4 = "programming";
        System.out.println("=== Test Case 4 (Detailed) ===");
        frequencySortWithDetails(s4);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 5: Bucket sort
        String s5 = "abacccdde";
        System.out.println("=== Test Case 5 (Bucket Sort) ===");
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output (Bucket): \"" + frequencySortBucket(s5) + "\"");
        System.out.println("Output (Heap): \"" + frequencySort(s5) + "\"");
    }
}
