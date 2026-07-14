package RecursionProb;

import java.util.*;

public class NQueensAllSolutions {
    private int N;
    private List<int[][]> solutions = new ArrayList<>();

    public NQueensAllSolutions(int N) {
        this.N = N;
    }

    public void solve() {
        int[][] board = new int[N][N];
        solveNQueens(board, 0);
        printAllSolutions();
    }

    private void solveNQueens(int[][] board, int col) {
        if (col == N) {
            // Found a valid solution
            int[][] solution = new int[N][N];
            for (int i = 0; i < N; i++)
                solution[i] = board[i].clone();
            solutions.add(solution);
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solveNQueens(board, col + 1);
                board[row][col] = 0; // Backtrack
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
        // Check left
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private void printAllSolutions() {
        int count = 1;
        for (int[][] solution : solutions) {
            System.out.println("Solution #" + count++);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print((solution[i][j] == 1 ? "Q " : ". "));
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total solutions: " + solutions.size());
    }

    public static void main(String[] args) {
        int N = 8; // You can change this to any value
        NQueensAllSolutions nQueens = new NQueensAllSolutions(N);
        nQueens.solve();
    }
}
