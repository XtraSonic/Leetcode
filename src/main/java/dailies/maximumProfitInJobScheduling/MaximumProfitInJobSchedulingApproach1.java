package dailies.maximumProfitInJobScheduling;

import java.util.HashMap;

public class MaximumProfitInJobSchedulingApproach1 implements MaximumProfitInJobScheduling {

    private HashMap<Integer, Integer> partialSum;

    @Override
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        partialSum = new HashMap<>();
        int currentTime = 0;
        int index = 0;
        return solveJobScheduling(currentTime, index, startTime, endTime, profit);
    }

    private int solveJobScheduling(int currentTime, int index, int[] startTime, int[] endTime, int[] profit) {
        while (index < startTime.length && startTime[index] < currentTime) {
            index++;
        }
        if (index >= startTime.length)
            return 0;
        if (index == startTime.length - 1)
            return profit[index];
        if (partialSum.containsKey(index))
            return partialSum.get(index);

        int assumeNotPickingJob = solveJobScheduling(startTime[index + 1], index + 1, startTime, endTime, profit);
        int assumePickingJob = solveJobScheduling(endTime[index], index + 1, startTime, endTime, profit);
        int maxSumForIndex = Math.max(assumeNotPickingJob, assumePickingJob + profit[index]);
        partialSum.put(index, maxSumForIndex);
        return maxSumForIndex;
    }
}
