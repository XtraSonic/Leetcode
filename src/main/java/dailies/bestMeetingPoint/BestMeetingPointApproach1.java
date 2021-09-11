package dailies.bestMeetingPoint;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BestMeetingPointApproach1 implements BestMeetingPoint {

    @Override
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int label = 1;
        GridNode[][] newGrid = new GridNode[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newGrid[i][j] = new GridNode();
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.add(new int[]{i, j, 0, label++});
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int numberOfStartingNodes = label - 1;
        while (!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            GridNode currentGridNode = newGrid[currentPoint[0]][currentPoint[1]];
            label = currentPoint[3];
            if (!currentGridNode.startingNodesThatVisited.containsKey(label)) {
                currentGridNode.rootsVisited++;
                currentGridNode.startingNodesThatVisited.put(label, currentPoint[2]);
                if (currentGridNode.rootsVisited == numberOfStartingNodes) {
                    result = Math.min(result, currentGridNode.startingNodesThatVisited.values().stream().mapToInt(e -> e).sum());
                }
                if (currentPoint[0] > 0) {
                    queue.add(new int[]{currentPoint[0] - 1, currentPoint[1], currentPoint[2] + 1, currentPoint[3]});
                }
                if (currentPoint[1] > 0) {
                    queue.add(new int[]{currentPoint[0], currentPoint[1] - 1, currentPoint[2] + 1, currentPoint[3]});
                }
                if (currentPoint[0] + 1 < n) {
                    queue.add(new int[]{currentPoint[0] + 1, currentPoint[1], currentPoint[2] + 1, currentPoint[3]});
                }
                if (currentPoint[1] + 1 < m) {
                    queue.add(new int[]{currentPoint[0], currentPoint[1] + 1, currentPoint[2] + 1, currentPoint[3]});
                }
            }

        }
        return result;
    }

    static class GridNode {
        int rootsVisited;
        Map<Integer, Integer> startingNodesThatVisited;

        public GridNode() {
            rootsVisited = 0;
            startingNodesThatVisited = new HashMap<>();
        }
    }
}
