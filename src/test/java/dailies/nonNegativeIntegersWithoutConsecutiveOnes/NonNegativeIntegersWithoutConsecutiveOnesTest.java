package dailies.nonNegativeIntegersWithoutConsecutiveOnes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NonNegativeIntegersWithoutConsecutiveOnesTest {
    NonNegativeIntegersWithoutConsecutiveOnes nniwco;

    @Test
    void test_5() {
        assertEquals(5, nniwco.findIntegers(5));
    }

    @Test
    void test_30() {
        assertEquals(13, nniwco.findIntegers(30));
    }

    @Test
    void test_0() {
        assertEquals(1, nniwco.findIntegers(0));
    }

    @Test
    void testEdgeNumbersUnder() {
        assertEquals(2, nniwco.findIntegers(1));
        assertEquals(3, nniwco.findIntegers(3));
        assertEquals(5, nniwco.findIntegers(7));
        assertEquals(8, nniwco.findIntegers(15));
        assertEquals(13, nniwco.findIntegers(31));
    }

    @Test
    void testEdgeNumbersOver() {
        assertEquals(3, nniwco.findIntegers(2));
        assertEquals(4, nniwco.findIntegers(4));
        assertEquals(6, nniwco.findIntegers(8));
        assertEquals(9, nniwco.findIntegers(16));
        assertEquals(14, nniwco.findIntegers(32));
    }


    @Test
    void runMax() {
        nniwco.findIntegers(1_000_000_000);
    }
}
