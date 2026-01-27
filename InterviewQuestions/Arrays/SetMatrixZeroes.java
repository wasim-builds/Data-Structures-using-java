package InterviewQuestions.Arrays;

import java.util.Arrays;

/**
 * LeetCode 73: Set Matrix Zeroes
 * 
 * Problem: Given an m x n matrix, if an element is 0, set its entire row and
 * column to 0.
 * Do it in-place.
 * 
 * Example:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Approach: Use first row and column as markers
 * - Use first row and column to mark which rows/columns need to be zeroed
 * - Use separate variables to track if first row/column themselves need zeroing
 * - Process matrix in two passes
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(1)
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row needs to be zeroed
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column needs to be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Set zeros based on markers (skip first row and column)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Helper method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[][] matrix1 = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        System.out.println("Test 1 - Before:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("After:");
        printMatrix(matrix1);
        // Expected: [[1,0,1],[0,0,0],[1,0,1]]

        // Test Case 2: Multiple zeros
        int[][] matrix2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        System.out.println("Test 2 - Before:");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("After:");
        printMatrix(matrix2);
        // Expected: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

        // Test Case 3: First row has zero
        int[][] matrix3 = {
                { 1, 0, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Test 3 - Before:");
        printMatrix(matrix3);
        setZeroes(matrix3);
        System.out.println("After:");
        printMatrix(matrix3);
        // Expected: [[0,0,0],[4,0,6],[7,0,9]]

        // Test Case 4: All zeros
        int[][] matrix4 = {
                { 0, 0 },
                { 0, 0 }
        };
        System.out.println("Test 4 - Before:");
        printMatrix(matrix4);
        setZeroes(matrix4);
        System.out.println("After:");
        printMatrix(matrix4);
        // Expected: [[0,0],[0,0]]
    }
}
