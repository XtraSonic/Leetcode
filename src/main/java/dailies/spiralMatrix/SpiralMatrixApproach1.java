package dailies.spiralMatrix;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixApproach1 implements SpiralMatrix {

    @Override
    public List<Integer> spiralOrder(int[][] matrix) {
        int minX = 0;
        int maxX = matrix[0].length - 1;
        int minY = 0;
        int maxY = matrix.length - 1;

        int currentDir = 0;
        List<Integer> result = new LinkedList<>();
        int currentX = 0;
        int currentY = 0;
        result.add(matrix[currentX][currentY]);

        while (minX <= maxX && minY <= maxY) {
            switch (currentDir) {
                case 0:
                    if (currentX + 1 <= maxX) {
                        currentX++;
                        result.add(matrix[currentY][currentX]);
                    } else {
                        currentDir = (currentDir + 1) % 4;
                        minY++;
                    }
                    break;
                case 1:
                    if (currentY + 1 <= maxY) {
                        currentY++;
                        result.add(matrix[currentY][currentX]);
                    } else {
                        currentDir = (currentDir + 1) % 4;
                        maxX--;
                    }
                    break;
                case 2:
                    if (currentX - 1 >= minX) {
                        currentX--;
                        result.add(matrix[currentY][currentX]);
                    } else {
                        currentDir = (currentDir + 1) % 4;
                        maxY--;
                    }
                    break;
                case 3:
                    if (currentY - 1 >= minY) {
                        currentY--;
                        result.add(matrix[currentY][currentX]);
                    } else {
                        currentDir = (currentDir + 1) % 4;
                        minX++;
                    }
                    break;

            }
        }
        return result;
    }
}
