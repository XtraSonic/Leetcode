package dailies.maximumProfitInJobScheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MaximumProfitInJobSchedulingApproach1 implements MaximumProfitInJobScheduling {

    private HashMap<Integer, Integer> partialSum;

    @Override
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        partialSum = new HashMap<>();
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(a -> a.startTime));
        return solveJobScheduling(0, 0, jobs);
    }

    private int solveJobScheduling(int currentTime, int index, List<Job> jobs) {
        while (index < jobs.size() && jobs.get(index).startTime < currentTime) {
            index++;
        }
        if (index >= jobs.size())
            return 0;
        if (index == jobs.size() - 1)
            return jobs.get(index).profit;
        if (partialSum.containsKey(index))
            return partialSum.get(index);

        int assumeNotPickingJob = solveJobScheduling(jobs.get(index + 1).startTime, index + 1, jobs);
        int assumePickingJob = solveJobScheduling(jobs.get(index).endTime, index + 1, jobs);
        int maxSumForIndex = Math.max(assumeNotPickingJob, assumePickingJob + jobs.get(index).profit);
        partialSum.put(index, maxSumForIndex);
        return maxSumForIndex;
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
