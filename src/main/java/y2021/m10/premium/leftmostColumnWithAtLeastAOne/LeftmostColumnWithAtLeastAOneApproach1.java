package y2021.m10.premium.leftmostColumnWithAtLeastAOne;

import commonUtilities.BinaryMatrix;

import java.util.List;

public class LeftmostColumnWithAtLeastAOneApproach1 implements LeftmostColumnWithAtLeastAOne {

    @Override
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int maxI = dimensions.get(0);
        int maxJ = dimensions.get(1);
        int currentI = 0;
        int currentJ = maxJ - 1;
        while (currentI < maxI && currentJ >= 0) {
            if (binaryMatrix.get(currentI, currentJ) == 1) {
                currentJ--;
            } else {
                currentI++;
            }
        }
        return currentJ == maxJ - 1 ? -1 : currentJ + 1;
    }
}
