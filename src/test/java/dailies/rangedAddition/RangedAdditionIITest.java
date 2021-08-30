package dailies.rangedAddition;

import dailies.rangeAdditionII.RangedAdditionII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class RangedAdditionIITest {
    RangedAdditionII rangedAdditionII;

    @Test
    void testExample1() {
        assertEquals(4, rangedAdditionII.maxCount(3, 3, new int[][]{
                new int[]{2, 2},
                new int[]{3, 3},
        }));
    }

    @Test
    void testExample2() {

        assertEquals(4, rangedAdditionII.maxCount(3, 3, new int[][]{
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{3, 3},
                new int[]{3, 3},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{3, 3},
                new int[]{3, 3},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{3, 3},
                new int[]{3, 3},
        }));
    }

    @Test
    void testExample3() {

        assertEquals(9, rangedAdditionII.maxCount(3, 3, new int[][]{
        }));
    }
}
