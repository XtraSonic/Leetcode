package mergeIntervals;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeIntervalsApproach1 implements MergeIntervals {

    @Override
    public int[][] merge(int[][] intervals) {
        List<int[]> disjointIntervals = new ArrayList<>();

        for (int[] currentInterval : intervals) {
            boolean shouldAdd = true;
            for (Iterator<int[]> it = disjointIntervals.iterator(); it.hasNext(); ) {
                int[] seenInterval = it.next();
                if (seenInterval[0] <= currentInterval[0] && currentInterval[1] <= seenInterval[1]) {
                    shouldAdd = false;
                    break;
                }
                if (currentInterval[0] <= seenInterval[0] && seenInterval[1] <= currentInterval[1]) {
                    it.remove();
                    continue;
                }
                if (currentInterval[0] <= seenInterval[0] && seenInterval[0] <= currentInterval[1]) {
                    currentInterval = new int[]{currentInterval[0], seenInterval[1]};
                    it.remove();
                    continue;
                }
                if (currentInterval[0] <= seenInterval[1] && seenInterval[1] <= currentInterval[1]) {

                    currentInterval = new int[]{seenInterval[0], currentInterval[1]};
                    it.remove();
                }
            }
            if (shouldAdd) {
                disjointIntervals.add(currentInterval);
            }
        }

        return disjointIntervals.toArray(int[][]::new);
    }


}
