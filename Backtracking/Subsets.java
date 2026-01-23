
/**
 * LeetCode #78 - Subsets
 * Difficulty: Medium
 * Time: O(2^n), Space: O(n)
 */
import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,
            List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
        // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    }
}
