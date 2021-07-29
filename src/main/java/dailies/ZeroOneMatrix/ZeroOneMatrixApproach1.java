package dailies.zeroOneMatrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZeroOneMatrixApproach1 implements ZeroOneMatrix {

    @Override
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<MatrixHelper> queue = new LinkedList<>();
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new MatrixHelper(i, j));
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            MatrixHelper currentLocation = queue.poll();
            int distanceFromZero = result[currentLocation.i][currentLocation.j];
            List<MatrixHelper> neighbours = getNeighbours(currentLocation, m, n, distanceFromZero);
            neighbours.forEach(neighbour -> {
                if (result[neighbour.i][neighbour.j] > distanceFromZero + 1) {
                    result[neighbour.i][neighbour.j] = distanceFromZero + 1;
                    queue.add(neighbour);
                }
            });

        }
        return result;
    }

    private List<MatrixHelper> getNeighbours(MatrixHelper current, int m, int n, int distance) {
        List<MatrixHelper> result = new LinkedList<>();
        if (current.i + 1 < m) {
            result.add(new MatrixHelper(current.i + 1, current.j, distance));
        }
        if (current.i - 1 >= 0) {
            result.add(new MatrixHelper(current.i - 1, current.j, distance));
        }
        if (current.j + 1 < n) {
            result.add(new MatrixHelper(current.i, current.j + 1, distance));
        }
        if (current.j - 1 >= 0) {
            result.add(new MatrixHelper(current.i, current.j - 1, distance));
        }
        return result;
    }

    private static class MatrixHelper {
        int i;
        int j;
        int distance;

        public MatrixHelper(int i, int j) {
            this.i = i;
            this.j = j;
            this.distance = 0;
        }

        public MatrixHelper(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }


    }
}
