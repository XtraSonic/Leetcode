package dailies.spiralMatrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SpiralMatrixTest {
    SpiralMatrix spiralMatrix;

    @Test
    void testExample1() {
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralMatrix.spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        }));
    }

    @Test
    void testExample2() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralMatrix.spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        }));
    }
}
