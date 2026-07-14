import java.util.HashSet;
import java.util.Set;

/**
 * Distribute Candies (LeetCode 575)
 * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.
 * The doctor advised Alice to only eat n / 2 of the candies she has.
 * Return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int type : candyType) {
            types.add(type);
        }
        return Math.min(types.size(), candyType.length / 2);
    }
}
