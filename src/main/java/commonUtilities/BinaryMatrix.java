package commonUtilities;

import java.util.Arrays;
import java.util.List;

public class BinaryMatrix {
    int[][] matrix;
    public int requestCounter;

    public BinaryMatrix(int[][] matrix) {
        this.matrix = matrix;
        requestCounter = 0;
    }


    public int get(int row, int col) {
        requestCounter++;
        return matrix[row][col];
    }

    public List<Integer> dimensions() {
        return Arrays.asList(matrix.length, matrix[0].length);
    }


}
