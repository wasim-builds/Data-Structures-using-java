package Dynamic_Programming;
class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int mini = prices[0]; // Track the minimum price so far
        int profit = 0; // Track the maximum profit

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini; // Calculate profit if sold today
            profit = Math.max(profit, cost); // Update max profit
            mini = Math.min(mini, prices[i]); // Update the minimum price
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToSellStock sol = new BestTimeToSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        System.out.println("Maximum Profit: " + sol.maxProfit(prices));
    }
}
