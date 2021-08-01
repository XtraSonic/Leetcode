package dailies.makingALargeIsland;

import commonUtilities.MatrixIndex;

import java.util.*;

public class MakingALargeIslandApproach1 implements MakingALargeIsland {

    @Override
    public int largestIsland(int[][] grid) {
        List<Island> islands = new ArrayList<>();
        Map<Integer, Integer> sizeByLabel = new HashMap<>();
        int n = grid.length;
        List<MatrixIndex> listOfZeros = new ArrayList<>();

        int currentLabel = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Island island = new Island(grid, new MatrixIndex(i, j), currentLabel);
                    islands.add(island);
                    sizeByLabel.put(currentLabel++, island.ones.size());
                }
                if (grid[i][j] == 0) {
                    listOfZeros.add(new MatrixIndex(i, j));
                }

            }
        }

        int nSquared = n * n;
        int numberOfIslands = islands.size();
        if (numberOfIslands == 1 && islands.get(0).ones.size() == nSquared) {
            return nSquared;
        }
        int max = 1;

        for (Island island : islands) {
            int tempMax = island.potentialMaxSize(sizeByLabel, grid);
            if (max < tempMax) {
                max = tempMax;
            }
        }

        return max;
    }

    static class Island {
        List<MatrixIndex> ones;
        List<MatrixIndex> border;

        Island(int[][] grid, MatrixIndex start, int label) {
            ones = new ArrayList<>();
            border = new ArrayList<>();
            int n = grid.length;
            Queue<MatrixIndex> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                MatrixIndex currentIndex = queue.poll();
                if (grid[currentIndex.i][currentIndex.j] == 1) {
                    grid[currentIndex.i][currentIndex.j] = label;
                    ones.add(currentIndex);
                    queue.addAll(currentIndex.getCardinalNeighbours(n));
                }
                if (grid[currentIndex.i][currentIndex.j] == 0) {
                    border.add(currentIndex);
                }
            }
        }

        public int potentialMaxSize(Map<Integer, Integer> sizeByLabel, int[][] grid) {
            int currentMax = ones.size() + 1;
            for (MatrixIndex borderElement : border) {
                Set<Integer> labels = new HashSet<>();
                for (MatrixIndex neighbour : borderElement.getCardinalNeighbours(grid.length)) {
                    if (grid[neighbour.i][neighbour.j] > 1)
                        labels.add(grid[neighbour.i][neighbour.j]);
                }
                int tempMax = labels.stream().map(sizeByLabel::get).reduce(1, Integer::sum);
                if (currentMax < tempMax) {
                    currentMax = tempMax;
                }
            }
            return currentMax;
        }
    }
}
