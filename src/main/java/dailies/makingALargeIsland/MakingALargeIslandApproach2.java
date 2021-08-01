package dailies.makingALargeIsland;


public class MakingALargeIslandApproach2 implements MakingALargeIsland {
    @Override
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int max = 1;
        int currentLabel = 2;
        boolean oneZeroExists = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    oneZeroExists = true;
                    grid[i][j] = 1;
                    int currentMax = calculateIslandSize(grid, i, j, currentLabel++);
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    grid[i][j] = 0;
                }
            }
        }
        return oneZeroExists ? max : n * n;
    }

    private int calculateIslandSize(int[][] grid, int startI, int startJ, int label) {
        if (startI < 0 || startJ < 0 || startI >= grid.length || startJ >= grid.length || grid[startI][startJ] == 0 || grid[startI][startJ] == label) {
            return 0;
        }
        grid[startI][startJ] = label;

        return 1 +
                calculateIslandSize(grid, startI - 1, startJ, label) +
                calculateIslandSize(grid, startI + 1, startJ, label) +
                calculateIslandSize(grid, startI, startJ - 1, label) +
                calculateIslandSize(grid, startI, startJ + 1, label);
    }
}
