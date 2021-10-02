package y2021.m10.dungeonGame;

public class DungeonGameApproach1 implements DungeonGame {

    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] hpNeededToThisPoint = new int[rows][cols];
        hpNeededToThisPoint[rows - 1][cols - 1] = -Math.min(dungeon[rows - 1][cols - 1] - 1, -1);
        for (int i = rows - 2; i >= 0; i--) {
            hpNeededToThisPoint[i][cols - 1] = -Math.min(-hpNeededToThisPoint[i + 1][cols - 1] + dungeon[i][cols - 1], -1);
        }
        for (int j = cols - 2; j >= 0; j--) {
            hpNeededToThisPoint[rows - 1][j] = -Math.min(-hpNeededToThisPoint[rows - 1][j + 1] + dungeon[rows - 1][j], -1);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                hpNeededToThisPoint[i][j] = -Math.min(-Math.min(hpNeededToThisPoint[i + 1][j], hpNeededToThisPoint[i][j + 1]) + dungeon[i][j], -1);
            }
        }
        return hpNeededToThisPoint[0][0];
    }
}
