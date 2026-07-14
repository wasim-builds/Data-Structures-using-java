import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III (LeetCode 216)
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * - Only numbers 1 through 9 are used.
 * - Each number is used at most once.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(ans, tempList, k, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
