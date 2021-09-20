package dailies.findWinnerOnATicTacToeGame;

public class FindWinnerOnATicTacToeGameApproach1 implements FindWinnerOnATicTacToeGame {


    @Override
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        boolean aTurn = true;
        for (int[] move : moves) {
            board[move[0]][move[1]] = aTurn ? 'A' : 'B';
            aTurn = !aTurn;
        }
        if (board[0][0] != 0 && board[0][0] == board[0][1] && board[0][0] == board[0][2])
            return String.valueOf(board[0][0]);
        if (board[1][0] != 0 && board[1][0] == board[1][1] && board[1][0] == board[1][2])
            return String.valueOf(board[1][0]);
        if (board[2][0] != 0 && board[2][0] == board[2][1] && board[2][0] == board[2][2])
            return String.valueOf(board[2][0]);

        if (board[0][0] != 0 && board[0][0] == board[1][0] && board[0][0] == board[2][0])
            return String.valueOf(board[0][0]);
        if (board[0][1] != 0 && board[0][1] == board[1][1] && board[0][1] == board[2][1])
            return String.valueOf(board[0][1]);
        if (board[0][2] != 0 && board[0][2] == board[1][2] && board[0][2] == board[2][2])
            return String.valueOf(board[0][2]);

        if (board[1][1] != 0 &&
                (
                        (board[0][0] == board[1][1] && board[2][2] == board[1][1])
                                || (board[0][2] == board[1][1] && board[2][0] == board[1][1])
                ))
            return String.valueOf(board[1][1]);

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
