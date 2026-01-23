/**
 * LeetCode #70 - Climbing Stairs
 * Difficulty: Easy
 * Time: O(n), Space: O(1)
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;

        int prev2 = 1, prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(5)); // 8
    }
}
