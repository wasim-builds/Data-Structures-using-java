package InterviewQuestions.Arrays;

import java.util.*;

/**
 * LeetCode 54: Spiral Matrix
 * 
 * Problem: Given an m x n matrix, return all elements of the matrix in spiral
 * order.
 * 
 * Example:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Approach: Layer-by-layer traversal
 * - Maintain four boundaries: top, bottom, left, right
 * - Traverse in order: right → down → left → up
 * - Shrink boundaries after each direction
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(1) excluding output array
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse right along top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse down along right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse left along bottom row (if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse up along left column (if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: 3x3 matrix
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Test 1: " + spiralOrder(matrix1));
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Test Case 2: 3x4 matrix
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println("Test 2: " + spiralOrder(matrix2));
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        // Test Case 3: Single row
        int[][] matrix3 = { { 1, 2, 3, 4 } };
        System.out.println("Test 3: " + spiralOrder(matrix3));
        // Expected: [1, 2, 3, 4]

        // Test Case 4: Single column
        int[][] matrix4 = { { 1 }, { 2 }, { 3 }, { 4 } };
        System.out.println("Test 4: " + spiralOrder(matrix4));
        // Expected: [1, 2, 3, 4]

        // Test Case 5: 1x1 matrix
        int[][] matrix5 = { { 7 } };
        System.out.println("Test 5: " + spiralOrder(matrix5));
        // Expected: [7]

        // Test Case 6: 2x2 matrix
        int[][] matrix6 = {
                { 1, 2 },
                { 3, 4 }
        };
        System.out.println("Test 6: " + spiralOrder(matrix6));
        // Expected: [1, 2, 4, 3]
    }
}
