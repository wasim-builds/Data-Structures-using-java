/**
 * LeetCode #121 - Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * 
 * Problem: Find maximum profit from buying and selling stock once.
 * You must buy before you sell.
 * 
 * Optimal Solution: Single Pass
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuySellStock {

    // Optimal Solution - Track minimum price and max profit
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Prices: " + java.util.Arrays.toString(prices1));
        System.out.println("Max Profit: " + maxProfit(prices1));
        // Expected: 5 (buy at 1, sell at 6)

        // Test Case 2
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("\nPrices: " + java.util.Arrays.toString(prices2));
        System.out.println("Max Profit: " + maxProfit(prices2));
        // Expected: 0 (no profit possible)

        // Test Case 3
        int[] prices3 = { 2, 4, 1 };
        System.out.println("\nPrices: " + java.util.Arrays.toString(prices3));
        System.out.println("Max Profit: " + maxProfit(prices3));
        // Expected: 2 (buy at 2, sell at 4)
    }
}
