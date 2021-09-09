package dailies.largestPlusSign;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LargestPlusSignTest {
    LargestPlusSign largestPlusSign;

    @Test
    void testExample1() {
        assertEquals(2, largestPlusSign.orderOfLargestPlusSign(5, new int[][]{
                new int[]{4, 2}
        }));
    }

    @Test
    void testExample2() {
        assertEquals(0, largestPlusSign.orderOfLargestPlusSign(1, new int[][]{
                new int[]{0, 0}
        }));
    }

    @Test
    void testNoMine() {
        assertEquals(3, largestPlusSign.orderOfLargestPlusSign(5, new int[][]{}));
        assertEquals(2, largestPlusSign.orderOfLargestPlusSign(4, new int[][]{}));
        assertEquals(2, largestPlusSign.orderOfLargestPlusSign(3, new int[][]{}));
        assertEquals(1, largestPlusSign.orderOfLargestPlusSign(2, new int[][]{}));
        assertEquals(1, largestPlusSign.orderOfLargestPlusSign(1, new int[][]{}));
    }

    @Test
    void testMaxRankWIthMines() {

        assertEquals(3, largestPlusSign.orderOfLargestPlusSign(5, new int[][]{
                new int[]{0, 0}
        }));
    }

    @Test
    void testAllMines() {
        assertEquals(0, largestPlusSign.orderOfLargestPlusSign(5, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{0, 4},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{2, 0},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{2, 3},
                new int[]{2, 4},
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 3},
                new int[]{3, 4},
                new int[]{4, 0},
                new int[]{4, 1},
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{4, 4},
        }));
    }

    @Test
    void testEvenMaxWithBombs() {

        assertEquals(3, largestPlusSign.orderOfLargestPlusSign(6, new int[][]{
                new int[]{4, 2}
        }));
    }


    @Test
    void testCarvedPlus() {
        assertEquals(2, largestPlusSign.orderOfLargestPlusSign(5, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 4},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{2, 4},
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 3},
                new int[]{3, 4},
                new int[]{4, 0},
                new int[]{4, 1},
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{4, 4},
        }));
    }

    @Test
    void testLarge() {
        assertEquals(250, largestPlusSign.orderOfLargestPlusSign(501, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 4},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{2, 4},
                new int[]{3, 0},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 3},
                new int[]{3, 4},
                new int[]{4, 0},
                new int[]{4, 1},
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{4, 4},
                new int[]{4, 5},
                new int[]{4, 6},
                new int[]{4, 7},
                new int[]{4, 8},
                new int[]{4, 9},
                new int[]{4, 10},
                new int[]{4, 11},
                new int[]{4, 12},
                new int[]{4, 13},
                new int[]{4, 14},
                new int[]{4, 15},
                new int[]{4, 16},
                new int[]{4, 17},
                new int[]{4, 18},
                new int[]{4, 19},
                new int[]{4, 20},
                new int[]{4, 21},
                new int[]{4, 22},
                new int[]{4, 23},
                new int[]{4, 24},
                new int[]{4, 25},
                new int[]{4, 26},
                new int[]{4, 27},
                new int[]{4, 28},
                new int[]{4, 29},
                new int[]{5, 0},
                new int[]{5, 1},
                new int[]{5, 2},
                new int[]{5, 3},
                new int[]{5, 4},
                new int[]{5, 5},
                new int[]{5, 6},
                new int[]{5, 7},
                new int[]{5, 8},
                new int[]{5, 9},
                new int[]{5, 10},
                new int[]{5, 11},
                new int[]{5, 12},
                new int[]{5, 13},
                new int[]{5, 14},
                new int[]{5, 15},
                new int[]{5, 16},
                new int[]{5, 17},
                new int[]{5, 18},
                new int[]{5, 19},
                new int[]{5, 20},
                new int[]{5, 21},
                new int[]{5, 22},
                new int[]{5, 23},
                new int[]{5, 24},
                new int[]{5, 25},
                new int[]{5, 26},
                new int[]{5, 27},
                new int[]{5, 28},
                new int[]{5, 29},
                new int[]{250, 0},
        }));
    }
}
