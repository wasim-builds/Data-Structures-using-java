package arrays;
public class SearchInSortedArray {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevent overflow

            if (nums[mid] == target) {
                return true;
            }

            // When low, mid, and high are equal, shrink boundaries
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInSortedArray solution = new SearchInSortedArray();

        int[] nums1 = {2,5,6,0,0,1,2};
        int target1 = 0;
        System.out.println("Search result for target 0: " + solution.search(nums1, target1)); // true

        int[] nums2 = {2,5,6,0,0,1,2};
        int target2 = 3;
        System.out.println("Search result for target 3: " + solution.search(nums2, target2)); // false
    }
}
