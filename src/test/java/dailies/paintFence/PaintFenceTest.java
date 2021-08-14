package dailies.paintFence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PaintFenceTest {
    PaintFence paintFence;

    @Test
    void testExample1() {
        assertEquals(6, paintFence.numWays(3, 2));
    }

    @Test
    void testExample2() {
        assertEquals(1, paintFence.numWays(1, 1));
    }

    @Test
    void testExample3() {
        assertEquals(42, paintFence.numWays(7, 2));
    }

    @Test
    void test4_2() {
        assertEquals(10, paintFence.numWays(4, 2));
    }


    @Test
    void test5_2() {
        assertEquals(16, paintFence.numWays(5, 2));
    }


    @Test
    void test6_2() {
        assertEquals(26, paintFence.numWays(6, 2));
    }

    @Test
    void test3_1() {
        assertEquals(0, paintFence.numWays(3, 1));
    }

    @Test
    void test3_3() {
        assertEquals(24, paintFence.numWays(3, 3));
    }
}
