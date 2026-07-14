package Algorithms.GreedyAlgorithms;

/**
 * Lemonade Change (LeetCode 860)
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time.
 * Return true if and only if you can provide every customer with correct change.
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
