package Dynamic_Programming;

public class MinCostClimbingStairs {
    public static int minCost(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Min Cost: " + minCost(cost));
    }
}
