package dailies.zeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixApproach1 implements ZeroOneMatrix {

    @Override
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<MatrixIndex> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = 0;
                    queue.add(new MatrixIndex(i, j));
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            MatrixIndex currentLocation = queue.poll();
            int i = currentLocation.i;
            int j = currentLocation.j;
            int currentFromZero = mat[currentLocation.i][currentLocation.j];
            if (i + 1 < m) {
                if (mat[i + 1][j] > currentFromZero + 1) {
                    mat[i + 1][j] = currentFromZero + 1;
                    queue.add(new MatrixIndex(i + 1, j));
                }
            }
            if (currentLocation.i - 1 >= 0) {
                if (mat[i - 1][j] > currentFromZero + 1) {
                    mat[i - 1][j] = currentFromZero + 1;
                    queue.add(new MatrixIndex(i - 1, j));
                }
            }
            if (currentLocation.j + 1 < n) {
                if (mat[i][j + 1] > currentFromZero + 1) {
                    mat[i][j + 1] = currentFromZero + 1;
                    queue.add(new MatrixIndex(i, j + 1));
                }
            }
            if (currentLocation.j - 1 >= 0) {
                if (mat[i][j - 1] > currentFromZero + 1) {
                    mat[i][j - 1] = currentFromZero + 1;
                    queue.add(new MatrixIndex(i, j - 1));
                }
            }

        }
        return mat;
    }

    private static class MatrixIndex {
        int i;
        int j;

        public MatrixIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
