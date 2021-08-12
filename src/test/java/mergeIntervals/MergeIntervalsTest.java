package mergeIntervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class MergeIntervalsTest {
    MergeIntervals mergeIntervals;

    @Test
    void testExample1() {
        assertArrayEquals(new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        }, mergeIntervals.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        }));
    }

    @Test
    void testExample2() {
        assertArrayEquals(new int[][]{
                {1, 5}
        }, mergeIntervals.merge(new int[][]{
                {1, 4},
                {4, 5}
        }));
    }
}
