package dailies.setMatrixZeros;

public class SetMatrixZerosApproach1 implements SetMatrixZeros {

    @Override
    public void setZeroes(int[][] matrix) {
        searchZeros(0, matrix);
    }

    private void searchZeros(int iAndJ, int[][] matrix) {
        int i = iAndJ / matrix[0].length;
        int j = iAndJ % matrix[0].length;
        if (i >= matrix.length || j >= matrix[0].length)
            return;
        boolean spreadZeros = matrix[i][j] == 0;
        searchZeros(iAndJ + 1, matrix);

        if (spreadZeros) {
            spreadZeros(i, j, -1, 0, matrix);
            spreadZeros(i, j, 1, 0, matrix);
            spreadZeros(i, j, 0, 1, matrix);
            spreadZeros(i, j, 0, -1, matrix);
        }

    }

    private void spreadZeros(int i, int j, int dirI, int dirJ, int[][] matrix) {
        int newI = i + dirI;
        int newJ = j + dirJ;
        if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length) {
            matrix[newI][newJ] = 0;
            spreadZeros(newI, newJ, dirI, dirJ, matrix);
        }
    }
}
