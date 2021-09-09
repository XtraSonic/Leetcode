package dailies.largestPlusSign;

public class LargestPlusSignApproach1 implements LargestPlusSign {

    @Override
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] maxRank = new int[n][n];
        for (int i = 0; i < n; i++) {
            int maxIRank = i < n / 2 ? i + 1 : (n - i);
            for (int j = 0; j < n; j++) {
                int maxJRank = j < n / 2 ? j + 1 : (n - j);
                maxRank[i][j] = Math.min(maxIRank, maxJRank);
            }
        }
        for (int[] mine : mines) {
            for (int j = mine[1] / 2; j < mine[1]; j++) {
                maxRank[mine[0]][j] = Math.min(maxRank[mine[0]][j], mine[1] - j);
            }
            for (int i = mine[0] / 2; i < mine[0]; i++) {
                maxRank[i][mine[1]] = Math.min(maxRank[i][mine[1]], mine[0] - i);
            }
            for (int j = mine[1]; j < n && j <= (n - mine[1]) / 2 + mine[1]; j++) {
                maxRank[mine[0]][j] = Math.min(maxRank[mine[0]][j], j - mine[1]);
            }
            for (int i = mine[0]; i < n && i <= (n - mine[0]) / 2 + mine[0]; i++) {
                maxRank[i][mine[1]] = Math.min(maxRank[i][mine[1]], i - mine[0]);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result < maxRank[i][j])
                    result = maxRank[i][j];
            }
        }
        return result;
    }
}
