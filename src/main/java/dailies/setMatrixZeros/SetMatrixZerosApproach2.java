package dailies.setMatrixZeros;

public class SetMatrixZerosApproach2 implements SetMatrixZeros {
    @Override
    public void setZeroes(int[][] matrix) {
        boolean firstLineShouldBeZero = false;
        boolean firstColumnShouldBeZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstLineShouldBeZero = true;
                    if (j == 0)
                        firstColumnShouldBeZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            } else {
                if (firstColumnShouldBeZero) {
                    matrix[i][0] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            } else {
                if (firstLineShouldBeZero) {
                    matrix[0][j] = 0;
                }
            }
        }
        if (firstLineShouldBeZero || firstColumnShouldBeZero) {
            matrix[0][0] = 0;
        }
    }
}
