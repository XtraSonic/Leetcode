package mergeIntervals;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MergeIntervalsApproach1 implements MergeIntervals {

    @Override
    public int[][] merge(int[][] intervals) {
        List<Interval> disjointIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            Interval currentInterval = new Interval(interval[0], interval[1]);
            for (Iterator<Interval> it = disjointIntervals.iterator(); it.hasNext(); ) {
                Interval seenInterval = it.next();
                if (seenInterval.canIntervalsBeMerged(currentInterval)) {
                    currentInterval = seenInterval.mergeIntervals(currentInterval);
                    it.remove();
                }
            }
            disjointIntervals.add(currentInterval);
        }

        return disjointIntervals.stream().map(Interval::toArray).toArray(int[][]::new);
    }

    private static class Interval {
        int start;
        int finish;

        public Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        boolean isInClosedInterval(int number) {
            return start <= number && number <= finish;
        }

        boolean isInsideInterval(Interval other) {
            return other.start <= start && other.finish >= finish;
        }

        boolean canIntervalsBeMerged(Interval other) {
            return isInsideInterval(other) || other.isInsideInterval(this) || isInClosedInterval(other.start) || isInClosedInterval(other.finish);
        }

        Interval mergeIntervals(Interval other) {
            return new Interval(Math.min(start, other.start), Math.max(finish, other.finish));
        }

        int[] toArray() {
            return new int[]{start, finish};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && finish == interval.finish;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, finish);
        }
    }


}
