package Dynamic_Programming;

public class HouseRobberII {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int next = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println("House Robber II: " + rob(nums));
    }
}
