package dailies.sudokuSolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class SudokuSolverTest {
    SudokuSolver sudokuSolver;

    @Test
    void testExample1() {
        evaluateSudokuSolver(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    @Test
    void testEmptySudoku() {
        evaluateSudokuSolver(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        });
    }

    @Test
    void testAlmostEmptySudoku() {
        evaluateSudokuSolver(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '9'}
        });
    }

    private void evaluateSudokuSolver(char[][] board) {
        sudokuSolver.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        boolean[][] seenElementOnLine = new boolean[9][9];
        boolean[][] seenElementOnColumn = new boolean[9][9];
        boolean[][] seenElementOnSquare = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    fail("The element on " + i + "," + j + " was not filled");
                int element = board[i][j] - '1';
                if (seenElementOnLine[i][element]) {
                    fail("Element on " + i + "," + j + " was already seen on the line");
                } else {
                    seenElementOnLine[i][element] = true;
                }
                if (seenElementOnColumn[j][element]) {
                    fail("Element on " + i + "," + j + " was already seen on the column");
                } else {
                    seenElementOnColumn[j][element] = true;
                }
                if (seenElementOnSquare[(i / 3) * 3 + j / 3][element]) {
                    fail("Element on " + i + "," + j + " was already seen in the square");
                } else {
                    seenElementOnSquare[(i / 3) * 3 + j / 3][element] = true;
                }

            }
        }
    }
}
