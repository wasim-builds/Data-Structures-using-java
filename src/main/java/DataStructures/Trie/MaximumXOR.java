package DataStructures.Trie;

/**
 * Maximum XOR of Two Numbers in an Array (LeetCode 421)
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 */
public class MaximumXOR {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root;

    public MaximumXOR() {
        root = new TrieNode();
    }

    private void insert(int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    /**
     * Finds the maximum XOR of any two numbers in the array.
     * @param nums Array of integers
     * @return The maximum XOR value
     */
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int maxXOR = 0;
        for (int num : nums) {
            TrieNode curr = root;
            int currentXOR = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = 1 - bit;
                if (curr.children[toggledBit] != null) {
                    currentXOR |= (1 << i);
                    curr = curr.children[toggledBit];
                } else {
                    curr = curr.children[bit];
                }
            }
            maxXOR = Math.max(maxXOR, currentXOR);
        }
        return maxXOR;
    }
}
