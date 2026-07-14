import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of Two Arrays (LeetCode 349)
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        
        return result;
    }
}
