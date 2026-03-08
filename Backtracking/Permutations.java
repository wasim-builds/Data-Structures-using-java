
/**
 * LeetCode #46 - Permutations
 * Difficulty: Medium
 * Time: O(n!), Space: O(n)
 */
import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,
            List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num))
                continue;

            current.add(num);
            backtrack(result, current, nums);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}
