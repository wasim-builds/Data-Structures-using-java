package arrays.arrays.binarySearch;

public class SearchIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Iterate over rows to find the potential row containing target
        for (int i = 0; i < matrix.length; i++) {
            // If target is less than or equal to the last element in row i,
            // the target could be in this row
            if (target <= matrix[i][matrix[0].length - 1]) {
                int left = 0;
                int right = matrix[i].length - 1;
                
                // Perform binary search on row i
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // If target is not found in this row, return false
                return false;
            }
        }
        // Target is not found in any row
        return false;
    }

    public static void main(String[] args) {
        SearchIn2D solution = new SearchIn2D();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target1 = 3;
        System.out.println("Searching for " + target1 + ": " + solution.searchMatrix(matrix, target1)); // true

        int target2 = 13;
        System.out.println("Searching for " + target2 + ": " + solution.searchMatrix(matrix, target2)); // false
    }
}
