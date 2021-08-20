package dailies.validSudoku;

public class ValidSudokuApproach1 implements ValidSudoku {

    @Override
    public boolean isValidSudoku(char[][] board) {
        boolean[][] seenElementOnLine = new boolean[9][9];
        boolean[][] seenElementOnColumn = new boolean[9][9];
        boolean[][] seenElementOnSquare = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    continue;
                int element = board[i][j] - '1';
                if (seenElementOnLine[i][element]) {
                    return false;
                } else {
                    seenElementOnLine[i][element] = true;
                }
                if (seenElementOnColumn[j][element]) {
                    return false;
                } else {
                    seenElementOnColumn[j][element] = true;
                }
                if (seenElementOnSquare[(i / 3) * 3 + j / 3][element]) {
                    return false;
                } else {
                    seenElementOnSquare[(i / 3) * 3 + j / 3][element] = true;
                }

            }
        }
        return true;
    }
}
