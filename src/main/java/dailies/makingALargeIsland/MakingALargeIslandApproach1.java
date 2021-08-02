package dailies.makingALargeIsland;

import commonUtilities.MatrixIndex;

import java.util.*;

public class MakingALargeIslandApproach1 implements MakingALargeIsland {

    @Override
    public int largestIsland(int[][] grid) {
        List<MatrixIndex> listOfZeros = new ArrayList<>();
        Map<Integer, Integer> sizeByLabel = new HashMap<>();
        int n = grid.length;

        int currentLabel = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Island island = new Island(grid, new MatrixIndex(i, j), currentLabel);
                    sizeByLabel.put(currentLabel++, island.size);
                }
                if (grid[i][j] == 0) {
                    listOfZeros.add(new MatrixIndex(i, j));
                }
            }
        }

        boolean atLeastOneZero = false;
        int max = 1;
        for (MatrixIndex borderElement : listOfZeros) {
            atLeastOneZero = true;
            Set<Integer> labels = new HashSet<>();
            for (MatrixIndex neighbour : borderElement.getCardinalNeighbours(grid.length)) {
                if (grid[neighbour.i][neighbour.j] > 1)
                    labels.add(grid[neighbour.i][neighbour.j]);
            }
            int tempMax = labels.stream().map(sizeByLabel::get).reduce(1, Integer::sum);
            if (max < tempMax) {
                max = tempMax;
            }
        }

        return atLeastOneZero ? max : n * n;
    }

    static class Island {
        int size;

        Island(int[][] grid, MatrixIndex start, int label) {
            size = 0;
            int n = grid.length;
            Queue<MatrixIndex> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                MatrixIndex currentIndex = queue.poll();
                if (grid[currentIndex.i][currentIndex.j] == 1) {
                    grid[currentIndex.i][currentIndex.j] = label;
                    size++;
                    queue.addAll(currentIndex.getCardinalNeighbours(n));
                }
            }
        }
    }
}
