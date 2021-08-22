package dailies.rectangleAreaII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class RectangleAreaIITest {
    RectangleAreaII rectangleAreaII;

    @Test
    void testExample1() {
        assertEquals(6, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 0, 2, 3},
                {1, 0, 3, 1},
        }));
    }

    @Test
    void testExample2() {
        assertEquals(49, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 1000000000, 1000000000}
        }));
    }

    @Test
    void testLOverlap() {
        assertEquals(8, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 0, 3, 3},
                {1, 0, 3, 1},
        }));
    }

    @Test
    void testOneOverlap() {
        assertEquals(8, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 0, 3, 3}
        }));
    }


    @Test
    void testNoOverlap() {
        assertEquals(7, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {2, 0, 3, 3}
        }));
    }

    @Test
    void testTotalOverlap() {
        assertEquals(49, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 0, 3, 3},
                {1, 0, 3, 1},
                {0, 0, 1000000000, 1000000000}
        }));
    }

    @Test
    void testSameStructureTwice() {
        assertEquals(4, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {0, 0, 2, 2},
        }));
    }

    @Test
    void testSameStructureThrice() {
        assertEquals(4, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {0, 0, 2, 2},
                {0, 0, 2, 2},
        }));
    }

    @Test
    void testSameStructureFourTimes() {
        assertEquals(4, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {0, 0, 2, 2},
                {0, 0, 2, 2},
        }));
    }


    @Test
    void testGrowingSquare() {
        assertEquals(25, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 1, 1},
                {0, 0, 2, 2},
                {0, 0, 3, 3},
                {0, 0, 4, 4},
                {0, 0, 5, 5},
        }));
    }

    @Test
    void testDisjointRectangles() {
        assertEquals(5, rectangleAreaII.rectangleArea(new int[][]{
                {0, 0, 1, 1},
                {0, 2, 3, 2},
                {2, 0, 2, 3},

        }));
    }
}
