package dailies.bestMeetingPoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BestMeetingPointTest {
    BestMeetingPoint bestMeetingPoint;

    @Test
    void testExample1() {
        assertEquals(6, bestMeetingPoint.minTotalDistance(new int[][]{
                new int[]{1, 0, 0, 0, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0},
        }));
    }

    @Test
    void testExample2() {
        assertEquals(1, bestMeetingPoint.minTotalDistance(new int[][]{
                new int[]{1, 1},
        }));
    }

    @Test
    void testMeetingPointIsAtOneFriend() {
        assertEquals(6, bestMeetingPoint.minTotalDistance(new int[][]{
                new int[]{1, 0, 1, 0, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0},
        }));
    }

    @Test
    void testMeetingPointIsInTheMiddle() {
        assertEquals(30, bestMeetingPoint.minTotalDistance(new int[][]{
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        }));
    }

    @Test
    void testWrongAnswer() {
        assertEquals(39, bestMeetingPoint.minTotalDistance(new int[][]{
                new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 0, 1, 0, 0, 0},
                new int[]{1, 1, 1, 0, 1, 0, 1, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0},
                new int[]{1, 0, 1, 1, 0, 1, 0, 0, 0},
        }));

    }
}
