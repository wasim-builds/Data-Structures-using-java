import java.util.HashMap;

public class AddSum {
    public static void main(String[] args) {
        // Test input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call twoSum function
        int[] result = twoSum(nums, target);

        // Print the result
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
