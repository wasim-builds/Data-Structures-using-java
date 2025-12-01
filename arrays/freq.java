package arrays;

import java.util.HashMap;
import java.util.Map;

public class freq {
    static void countFreq(int arr[], int n) {
        Map<Integer, Integer> mp = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Print frequency of each unique element
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 10, 20, 10, 30, 40, 10, 20, 20};
        countFreq(arr, arr.length);
    }
}
