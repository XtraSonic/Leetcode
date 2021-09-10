package dailies.arithmeticSlicesIISubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ArithmeticSlicesIISubsequenceTest {
    ArithmeticSlicesIISubsequence arithmeticSlicesIISubsequence;

    @Test
    void testExample1() {
        assertEquals(7, arithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
    }

    @Test
    void testExample2() {
        assertEquals(16, arithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }


    @Test
    void testExample1With14() {
        assertEquals(10, arithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10, 14}));
    }

    @Test
    void testLargerSet() {
        arithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14, 2, 4, 6, 8, 10, 14});
    }

    @Test
    void testLargeDiff() {
        assertEquals(0, arithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
    }
}
