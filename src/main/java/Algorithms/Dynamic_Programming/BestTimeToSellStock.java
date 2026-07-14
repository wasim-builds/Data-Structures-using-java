package Dynamic_Programming;
class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0]; // Track the minimum price so far
        int maxprofit = 0; // Track the maximum profit

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min; // Calculate profit if sold today
            maxprofit = Math.max(profit, profit); // Update max profit
            min = Math.min(min, prices[i]); // Update the minimum price
        }

        return maxprofit;
    }

    public static void main(String[] args) {
        BestTimeToSellStock sol = new BestTimeToSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        System.out.println("Maximum Profit: " + sol.maxProfit(prices));
    }
}
