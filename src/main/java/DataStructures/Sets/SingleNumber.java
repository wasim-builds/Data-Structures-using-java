package DataStructures.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Single Number (LeetCode 136)
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // While typically solved with XOR, here is a Set approach.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }
}
