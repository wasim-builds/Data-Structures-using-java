
/**
 * LeetCode #39 - Combination Sum
 * Difficulty: Medium
 * Time: O(2^n), Space: O(target/min)
 */
import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,
            List<Integer> current,
            int[] candidates,
            int target,
            int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        // [[2,2,3],[7]]

        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
        // [[2,2,2,2],[2,3,3],[3,5]]
    }
}
