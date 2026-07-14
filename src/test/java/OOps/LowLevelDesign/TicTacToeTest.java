package OOps.LowLevelDesign;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testPlayer1WinsRow() {
        TicTacToe game = new TicTacToe(3);
        assertEquals(0, game.move(0, 0, 1)); // Player 1
        assertEquals(0, game.move(1, 0, 2)); // Player 2
        assertEquals(0, game.move(0, 1, 1)); // Player 1
        assertEquals(0, game.move(1, 1, 2)); // Player 2
        // Player 1 completes row 0
        assertEquals(1, game.move(0, 2, 1)); 
    }

    @Test
    public void testPlayer2WinsDiagonal() {
        TicTacToe game = new TicTacToe(3);
        assertEquals(0, game.move(0, 1, 1)); // Player 1
        assertEquals(0, game.move(0, 0, 2)); // Player 2
        assertEquals(0, game.move(1, 0, 1)); // Player 1
        assertEquals(0, game.move(1, 1, 2)); // Player 2
        assertEquals(0, game.move(2, 0, 1)); // Player 1
        // Player 2 completes diagonal
        assertEquals(2, game.move(2, 2, 2)); 
    }
}
