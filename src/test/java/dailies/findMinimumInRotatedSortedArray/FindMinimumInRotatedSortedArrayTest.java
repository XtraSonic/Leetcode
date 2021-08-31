package dailies.findMinimumInRotatedSortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class FindMinimumInRotatedSortedArrayTest {
    FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray;

    @Test
    void testExample1() {
        assertEquals(1, findMinimumInRotatedSortedArray.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void testExample2() {
        assertEquals(0, findMinimumInRotatedSortedArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    void testExample3() {
        assertEquals(11, findMinimumInRotatedSortedArray.findMin(new int[]{11, 13, 15, 17}));
    }

    @Test
    void testCenterIsMin() {
        assertEquals(0, findMinimumInRotatedSortedArray.findMin(new int[]{4, 5, 0, 1, 2}));
    }

    @Test
    void testEvenCenterIsMin() {
        assertEquals(0, findMinimumInRotatedSortedArray.findMin(new int[]{4, 0, 1, 2}));
        assertEquals(0, findMinimumInRotatedSortedArray.findMin(new int[]{4, 5, 0, 2}));
    }

    @Test
    void testAllPossibilitiesForLength6() {
        evaluateAllPossibilitiesForLength(6);
    }

    @Test
    void testAllPossibilitiesForLength7() {
        evaluateAllPossibilitiesForLength(7);
    }

    private void evaluateAllPossibilitiesForLength(int length) {
        for (int offset = 0; offset < length; offset++) {
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[(i + offset) % length] = i;
            }
            assertEquals(0, findMinimumInRotatedSortedArray.findMin(array));
        }
    }
}
