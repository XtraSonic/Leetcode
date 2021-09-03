package dailies.erectTheFence;

import java.util.Arrays;
import java.util.Stack;

public class ErectTheFenceApproach1 implements ErectTheFence {

    @Override
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3)
            return trees;
        Stack<int[]> currentLine = new Stack<>();
        int[] minPoint = trees[0];
        for (int i = 1; i < trees.length; i++) {
            if (minPoint[0] > trees[i][0]) {
                minPoint = trees[i];
            } else if (minPoint[0] == trees[i][0] && minPoint[1] > trees[i][1]) {
                minPoint = trees[i];
            }
        }
        int[] startingPoint = minPoint;
        Arrays.sort(trees, (a, b) -> {
            int differenceBetweenAandB = comparedPointToLine(b, startingPoint, a) - comparedPointToLine(a, startingPoint, b);
            if (differenceBetweenAandB == 0) {
                return getDistanceSquaredBetweenPoints(startingPoint, a) - getDistanceSquaredBetweenPoints(startingPoint, b);
            }
            return differenceBetweenAandB;
        });
        int lastColeniarIndex = trees.length - 1;
        while (lastColeniarIndex >= 0 && comparedPointToLine(trees[lastColeniarIndex], startingPoint, trees[trees.length - 1]) == 0)
            lastColeniarIndex--;
        for (int leftIndex = lastColeniarIndex + 1, rightIndex = trees.length - 1; leftIndex < rightIndex; leftIndex++, rightIndex--) {
            int[] temp = trees[leftIndex];
            trees[leftIndex] = trees[rightIndex];
            trees[rightIndex] = temp;
        }
        currentLine.push(trees[0]);
        currentLine.push(trees[1]);
        for (int i = 2; i < trees.length; i++) {
            int[] endOfCurrentLine = currentLine.pop();
            while (comparedPointToLine(trees[i], currentLine.peek(), endOfCurrentLine) > 0) {
                endOfCurrentLine = currentLine.pop();
            }
            currentLine.push(endOfCurrentLine);
            currentLine.push(trees[i]);
        }
        return currentLine.toArray(new int[currentLine.size()][]);
    }

    private int getDistanceSquaredBetweenPoints(int[] a, int[] b) {
        int x = (a[0] - b[0]);
        int y = (a[1] - b[1]);
        return x * x + y * y;
    }

    private int comparedPointToLine(int[] point, int[] lineStart, int[] lineEnd) {
        return (lineEnd[1] - lineStart[1]) * (point[0] - lineEnd[0]) - (lineEnd[0] - lineStart[0]) * (point[1] - lineEnd[1]);
    }
}
