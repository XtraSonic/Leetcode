package dailies.arrayOfDoubledPairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ArrayOfDoubledPairsTest {
    ArrayOfDoubledPairs arrayOfDoubledPairs;

    @Test
    void testExample1() {
        assertFalse(arrayOfDoubledPairs.canReorderDoubled(new int[]{3, 1, 3, 6}));
    }

    @Test
    void testExample2() {
        assertFalse(arrayOfDoubledPairs.canReorderDoubled(new int[]{2, 1, 2, 6}));
    }

    @Test
    void testExample3() {
        assertTrue(arrayOfDoubledPairs.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

    @Test
    void testExample4() {
        assertFalse(arrayOfDoubledPairs.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
    }

    @Test
    void testValueIsBothOnEvenAndOddIndex() {
        assertTrue(arrayOfDoubledPairs.canReorderDoubled(new int[]{2, 1, 2, 4}));
    }

    @Test
    void testPossiblePairShouldNotBeMadeFirst() {
        assertTrue(arrayOfDoubledPairs.canReorderDoubled(new int[]{4, 8, 2, 16}));
    }

    @Test
    void testFailedTest() {
        assertFalse(arrayOfDoubledPairs.canReorderDoubled(new int[]{-5, -2}));
    }
}
