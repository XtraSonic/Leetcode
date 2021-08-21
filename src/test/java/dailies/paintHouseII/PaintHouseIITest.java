package dailies.paintHouseII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PaintHouseIITest {
    PaintHouseII paintHouseII;

    @Test
    void testExample1() {
        assertEquals(5, paintHouseII.minCostII(new int[][]{
                {1, 5, 3},
                {2, 9, 4}
        }));
    }

    @Test
    void testExample2() {
        assertEquals(5, paintHouseII.minCostII(new int[][]{
                {1, 3},
                {2, 4}
        }));
    }

    @Test
    void testThirdLowestShouldBeChosenForSecondLowest() {
        assertEquals(6, paintHouseII.minCostII(new int[][]{
                {1, 100, 1001},
                {3, 2, 4},
                {1000, 1, 10000}
        }));
    }

    @Test
    void testWrongAnswer() {
        assertEquals(181, paintHouseII.minCostII(new int[][]{
                {14, 18, 16},
                {18, 4, 9},
                {2, 20, 2},
                {4, 19, 10},
                {7, 13, 4},
                {11, 4, 17},
                {10, 11, 20},
                {8, 3, 16},
                {4, 17, 15},
                {8, 7, 3},
                {1, 19, 4},
                {12, 11, 18},
                {10, 5, 6},
                {14, 19, 19},
                {5, 8, 12},
                {12, 16, 13},
                {20, 8, 16},
                {17, 15, 2},
                {14, 2, 20},
                {2, 6, 14},
                {3, 17, 17},
                {17, 8, 3},
                {16, 8, 4},
                {7, 14, 8},
                {13, 3, 7},
                {15, 11, 14},
                {19, 20, 10},
                {4, 2, 6}
        }));
    }
}
