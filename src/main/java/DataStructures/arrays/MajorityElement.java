package arrays;

import java.util.HashMap;

class majorityElement {
    static void findMajority(int arr[], int n) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majorityElement = -1, majorityCount = 0;

        for (int num : arr) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            // Track the element with the highest count
            if (count > majorityCount) {
                majorityCount = count;
                majorityElement = num;
            }
        }

        // Check if it appears more than n/2 times
        if (majorityCount > n / 2) {
            System.out.println(majorityElement);
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1, 3, 5, 1};
        findMajority(arr, arr.length);
    }
}
