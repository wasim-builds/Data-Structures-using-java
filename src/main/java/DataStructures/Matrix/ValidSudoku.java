package DataStructures.Matrix;

import java.util.HashSet;

/**
 * Valid Sudoku (LeetCode 36)
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    if (!seen.add(curr + " found in row " + i) ||
                        !seen.add(curr + " found in column " + j) ||
                        !seen.add(curr + " found in sub-box " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
