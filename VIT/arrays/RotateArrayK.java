public class RotateArrayK {
    // Method to rotate the array by k positions
    public static int[] rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;  // In case k is greater than the array length
        reverse(nums, 0, n - 1);  // Reverse the entire array
        reverse(nums, 0, k - 1);  // Reverse the first k elements
        reverse(nums, k, n - 1);  // Reverse the remaining elements
        return nums;
    }

    // Helper method to reverse a part of the array
    public static void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};  // Sample array
        int k = 3;  // Number of positions to rotate
        
        // Rotate the array
        int[] rotatedArray = rotate(nums, k);
        
        // Print the rotated array
        System.out.print("Rotated Array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}


