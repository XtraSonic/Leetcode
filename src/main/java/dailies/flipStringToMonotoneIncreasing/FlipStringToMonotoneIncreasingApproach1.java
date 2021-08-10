package dailies.flipStringToMonotoneIncreasing;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasingApproach1 implements FlipStringToMonotoneIncreasing {

    @Override
    public int minFlipsMonoIncr(String s) {
        int[] numberOfZerosUpToIndex = new int[s.length()];
        int[] numberOfOnesAfterIndex = new int[s.length()];

        numberOfOnesAfterIndex[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                numberOfOnesAfterIndex[i] = numberOfOnesAfterIndex[i + 1] + 1;
            } else {
                numberOfOnesAfterIndex[i] = numberOfOnesAfterIndex[i + 1];
            }
        }
        numberOfZerosUpToIndex[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                numberOfZerosUpToIndex[i] = numberOfZerosUpToIndex[i - 1] + 1;
            } else {
                numberOfZerosUpToIndex[i] = numberOfZerosUpToIndex[i - 1];
            }
        }

        int minChanges = Math.min(s.length() - numberOfZerosUpToIndex[s.length() - 1], s.length() - numberOfOnesAfterIndex[0]);

        int index = minChanges == s.length() - numberOfOnesAfterIndex[0] ? 0 : s.length();

        for (int indexWhereOnesStart = 1; indexWhereOnesStart < s.length(); indexWhereOnesStart++) {
            int numberOfFlippedZeros = indexWhereOnesStart - numberOfZerosUpToIndex[indexWhereOnesStart - 1];
            int numberOfFlippedOnes = s.length() - indexWhereOnesStart - numberOfOnesAfterIndex[indexWhereOnesStart];
            int currentChanges = numberOfFlippedZeros + numberOfFlippedOnes;
            if (minChanges > currentChanges) {
                minChanges = currentChanges;
                index = indexWhereOnesStart;
            }
        }

        System.out.println(s + " " + Arrays.toString(numberOfZerosUpToIndex) + " " + Arrays.toString(numberOfOnesAfterIndex) + " " + index);
        return minChanges;
    }
}
