package dailies.makingALargeIsland;


public class MakingALargeIslandApproach3 implements MakingALargeIsland {

    @Override
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] sizeByLabel = new int[n * n];
        sizeByLabel[0] = 0;
        int currentLabel = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sizeByLabel[currentLabel] = calculateIslandSize(grid, i, j, currentLabel);
                    currentLabel++;
                }
            }
        }

        boolean oneZeroExists = false;
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                oneZeroExists = true;
                int upLabel = 0;
                int downLabel = 0;
                int leftLabel = 0;
                int rightLabel = 0;
                if (i + 1 < n && grid[i + 1][j] > 1) {
                    upLabel = grid[i + 1][j];
                }
                if (i - 1 >= 0 && grid[i - 1][j] > 1 && grid[i - 1][j] != upLabel) {
                    downLabel = grid[i - 1][j];
                }
                if (j + 1 < n && grid[i][j + 1] > 1 && grid[i][j + 1] != upLabel && grid[i][j + 1] != downLabel) {
                    leftLabel = grid[i][j + 1];
                }
                if (j - 1 >= 0 && grid[i][j - 1] > 1 && grid[i][j - 1] != upLabel && grid[i][j - 1] != downLabel && grid[i][j - 1] != leftLabel) {
                    rightLabel = grid[i][j - 1];
                }
                int tempMax = sizeByLabel[upLabel] + sizeByLabel[downLabel] + sizeByLabel[leftLabel] + sizeByLabel[rightLabel] + 1;
                if (max < tempMax) {
                    max = tempMax;
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
