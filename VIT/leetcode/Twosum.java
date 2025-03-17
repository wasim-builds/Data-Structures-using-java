package leetcode;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int x = target - cur;
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(cur, i);
        }
        return null;
    }
}

public class Twosum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Taking user input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Taking user input for the target value
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Solving the two-sum problem
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        // Printing the result
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }

        scanner.close();
    }
}
