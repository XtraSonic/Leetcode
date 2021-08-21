package dailies.sudokuSolver;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolverApproach1 implements SudokuSolver {

    boolean[][] elementsOnLine;
    boolean[][] elementsOnColumn;
    boolean[][] elementsOnSquare;

    @Override
    public void solveSudoku(char[][] board) {
        elementsOnLine = new boolean[9][9];
        elementsOnColumn = new boolean[9][9];
        elementsOnSquare = new boolean[9][9];

        List<int[]> dots = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '1';
                    elementsOnLine[i][number] = true;
                    elementsOnColumn[j][number] = true;
                    elementsOnSquare[(i / 3) * 3 + (j / 3)][number] = true;
                } else {
                    dots.add(new int[]{i, j});
                }
            }
        }
        solveSudoku(board, dots, 0);
    }

    private boolean solveSudoku(char[][] board, List<int[]> dots, int dotIndex) {
        if (dotIndex == dots.size()) {
            return true;
        }
        int[] currentElement = dots.get(dotIndex);
        int i = currentElement[0];
        int j = currentElement[1];
        for (int number = 0; number < 9; number++) {
            if (elementsOnLine[i][number] || elementsOnColumn[j][number] || elementsOnSquare[(i / 3) * 3 + (j / 3)][number]) {
                continue;
            }
            elementsOnLine[i][number] = true;
            elementsOnColumn[j][number] = true;
            elementsOnSquare[(i / 3) * 3 + (j / 3)][number] = true;
            board[i][j] = '1';
            board[i][j] += number;
            if (solveSudoku(board, dots, dotIndex + 1)) {
                return true;
            }
            elementsOnLine[i][number] = false;
            elementsOnColumn[j][number] = false;
            elementsOnSquare[(i / 3) * 3 + (j / 3)][number] = false;
            board[i][j] = '.';
        }
        return false;

    }
}
