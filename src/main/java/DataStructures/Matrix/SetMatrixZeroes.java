package DataStructures.Matrix;

/**
 * Set Matrix Zeroes (LeetCode 73)
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}
