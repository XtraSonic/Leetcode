package dailies.patchingArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PatchingArrayTest {
    PatchingArray patchingArray;

    @Test
    void testExample1() {
        assertEquals(1, patchingArray.minPatches(new int[]{1, 3}, 6));
    }

    @Test
    void testExample2() {
        assertEquals(2, patchingArray.minPatches(new int[]{1, 5, 10}, 20));
    }

    @Test
    void testExample3() {
        assertEquals(0, patchingArray.minPatches(new int[]{1, 2, 2}, 5));
    }

    @Test
    void testLargeN() {
        assertEquals(28, patchingArray.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }

    @Test
    void testFailedTest() {
        assertEquals(2, patchingArray.minPatches(new int[]{1, 7, 21, 31, 34, 37, 40, 43, 49, 87, 90, 92, 93, 98, 99}, 12));
    }
}
