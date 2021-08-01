package dailies.makingALargeIsland;

import commonUtilities.MatrixIndex;

import java.util.*;

public class MakingALargeIslandApproach1 implements MakingALargeIsland {

    @Override
    public int largestIsland(int[][] grid) {
        List<Island> islands = new ArrayList<>();
        int n = grid.length;
        List<MatrixIndex> listOfZeros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands.add(new Island(grid, new MatrixIndex(i, j)));
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

        for (MatrixIndex zeroIndex : listOfZeros) {
            int maxChangeForThisZero = 1;
            List<MatrixIndex> zeroNeighbours = zeroIndex.getCardinalNeighbours(n);
            Set<Island> neighbouringIslands = new HashSet<>();
            for (MatrixIndex zeroNeighbour : zeroNeighbours) {
                if (grid[zeroNeighbour.i][zeroNeighbour.j] != 0) {
                    Island neighbourIsland = islands.stream().filter(island -> island.ones.contains(zeroNeighbour)).findFirst().orElseThrow();
                    neighbouringIslands.add(neighbourIsland);
                }
            }
            for (Island neighbour : neighbouringIslands) {
                maxChangeForThisZero += neighbour.ones.size();
            }
            if (max < maxChangeForThisZero) {
                max = maxChangeForThisZero;
            }
        }

        return max;
    }

    static class Island {
        List<MatrixIndex> ones;

        Island(int[][] grid, MatrixIndex start) {
            ones = new ArrayList<>();
            int n = grid.length;
            Queue<MatrixIndex> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                MatrixIndex currentIndex = queue.poll();
                if (grid[currentIndex.i][currentIndex.j] == 1) {
                    grid[currentIndex.i][currentIndex.j] = -1;
                    ones.add(currentIndex);
                    queue.addAll(currentIndex.getCardinalNeighbours(n));
                }
            }
        }
    }
}
