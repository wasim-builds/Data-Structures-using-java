package arrays;
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check if the matrix is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // Get the number of rows and columns in the matrix
        int ROWS = matrix.length, COLS = matrix[0].length;
        // Initialize the left and right pointers for binary search
        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            // Compute the middle index
            int m = l + (r - l) / 2;
            // Convert the index m to row and column in the matrix
            int row = m / COLS;
            int col = m % COLS;

            // Compare the target with the element at the computed coordinates
            if (target > matrix[row][col]) {
                l = m + 1; // Move the left pointer up
            } else if (target < matrix[row][col]) {
                r = m - 1; // Move the right pointer down
            } else {
                return true; // Target found
            }
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        Search2dMatrix solution = new Search2dMatrix();
        
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + (result ? " found." : " not found."));

        target = 13;
        result = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + (result ? " found." : " not found."));
    }
}
