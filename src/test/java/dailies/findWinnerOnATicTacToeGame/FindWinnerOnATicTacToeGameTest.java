package dailies.findWinnerOnATicTacToeGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class FindWinnerOnATicTacToeGameTest {
    FindWinnerOnATicTacToeGame findWinnerOnATicTacToeGame;

    @Test
    void testExample1() {
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0},
                new int[]{2, 0},
                new int[]{1, 1},
                new int[]{2, 1},
                new int[]{2, 2},
        }));
    }

    @Test
    void testExample2() {
        assertEquals("B", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 0},
                new int[]{2, 0},
        }));
    }

    @Test
    void testExample3() {
        assertEquals("Draw", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{2, 2},
        }));
    }

    @Test
    void testExample4() {
        assertEquals("Pending", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
        }));
    }


    @Test
    void testEveryWin() {
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0}, new int[]{2, 1},
                new int[]{0, 1}, new int[]{2, 0},
                new int[]{0, 2},
        }));
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{1, 0}, new int[]{0, 1},
                new int[]{1, 1}, new int[]{2, 0},
                new int[]{1, 2},
        }));
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{2, 0}, new int[]{0, 1},
                new int[]{2, 1}, new int[]{1, 0},
                new int[]{2, 2},
        }));

        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0}, new int[]{0, 1},
                new int[]{1, 0}, new int[]{2, 2},
                new int[]{2, 0},
        }));
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 1}, new int[]{2, 0},
                new int[]{1, 1}, new int[]{1, 0},
                new int[]{2, 1},
        }));
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 2}, new int[]{0, 1},
                new int[]{1, 2}, new int[]{1, 1},
                new int[]{2, 2},
        }));

        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{0, 0}, new int[]{0, 1},
                new int[]{1, 1}, new int[]{1, 0},
                new int[]{2, 2},
        }));
        assertEquals("A", findWinnerOnATicTacToeGame.tictactoe(new int[][]{
                new int[]{2, 0}, new int[]{0, 1},
                new int[]{1, 1}, new int[]{1, 0},
                new int[]{0, 2},
        }));
    }
}
