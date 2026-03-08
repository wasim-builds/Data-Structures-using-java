import java.util.*;

/**
 * Fractional Knapsack Problem
 * Time Complexity: O(n log n) for sorting
 * Space Complexity: O(n)
 * 
 * Greedy approach: Select items by value-to-weight ratio
 */
public class FractionalKnapsack {

    static class Item {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    // Get maximum value that can be obtained
    public static double getMaxValue(int[] values, int[] weights, int capacity) {
        int n = values.length;
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(values[i], weights[i]));
        }

        // Sort by value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                // Take whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take fraction of item
                totalValue += item.ratio * remainingCapacity;
                break;
            }
        }

        return totalValue;
    }

    // Get detailed solution showing which items are selected
    public static void getDetailedSolution(int[] values, int[] weights, int capacity) {
        int n = values.length;
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(values[i], weights[i]));
        }

        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0;
        int remainingCapacity = capacity;

        System.out.println("Items selected:");
        System.out.println("Value\tWeight\tRatio\t\tFraction");
        System.out.println("-----\t------\t-----\t\t--------");

        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                System.out.printf("%d\t%d\t%.2f\t\t1.00\n",
                        item.value, item.weight, item.ratio);
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else if (remainingCapacity > 0) {
                double fraction = (double) remainingCapacity / item.weight;
                System.out.printf("%d\t%d\t%.2f\t\t%.2f\n",
                        item.value, item.weight, item.ratio, fraction);
                totalValue += item.ratio * remainingCapacity;
                remainingCapacity = 0;
                break;
            }
        }

        System.out.printf("\nTotal value: %.2f\n", totalValue);
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        System.out.println("Fractional Knapsack Problem");
        System.out.println("Capacity: " + capacity);
        System.out.println("\nItems:");
        for (int i = 0; i < values.length; i++) {
            System.out.println("Item " + (i + 1) + ": Value=" + values[i] +
                    ", Weight=" + weights[i]);
        }

        System.out.println("\n" + "=".repeat(50));
        getDetailedSolution(values, weights, capacity);

        // Another example
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nExample 2:");
        int[] values2 = { 10, 5, 15, 7, 6, 18, 3 };
        int[] weights2 = { 2, 3, 5, 7, 1, 4, 1 };
        int capacity2 = 15;

        System.out.println("Capacity: " + capacity2);
        getDetailedSolution(values2, weights2, capacity2);
    }
}
