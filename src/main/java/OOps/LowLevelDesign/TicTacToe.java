package OOps.LowLevelDesign;

/**
 * Low Level Design (LLD) for Tic-Tac-Toe.
 * 
 * Commonly asked in MAANG interviews (e.g., Amazon, Microsoft).
 * The naïve approach checks the whole board O(N^2) on every move.
 * The optimal approach (implemented below) solves this in O(1) time per move!
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    /**
     * Initialize your data structure here.
     * @param n The size of the tic-tac-toe board (n x n).
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     *         0: No one wins.
     *         1: Player 1 wins.
     *         2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int val = (player == 1) ? 1 : -1;

        rows[row] += val;
        cols[col] += val;

        if (row == col) {
            diagonal += val;
        }
        if (col == (n - row - 1)) {
            antiDiagonal += val;
        }

        // Check if the current player has won
        if (Math.abs(rows[row]) == n || 
            Math.abs(cols[col]) == n || 
            Math.abs(diagonal) == n || 
            Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0; // No one has won yet
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        System.out.println("Player 1 moves at (0,0): " + game.move(0, 0, 1)); // returns 0
        System.out.println("Player 2 moves at (0,2): " + game.move(0, 2, 2)); // returns 0
        System.out.println("Player 1 moves at (2,2): " + game.move(2, 2, 1)); // returns 0
        System.out.println("Player 2 moves at (1,1): " + game.move(1, 1, 2)); // returns 0
        System.out.println("Player 1 moves at (2,0): " + game.move(2, 0, 1)); // returns 0
        System.out.println("Player 2 moves at (1,0): " + game.move(1, 0, 2)); // returns 0
        System.out.println("Player 1 moves at (2,1): " + game.move(2, 1, 1)); // returns 1 (Player 1 wins!)
    }
}
