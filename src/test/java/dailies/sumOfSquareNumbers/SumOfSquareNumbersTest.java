package dailies.sumOfSquareNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SumOfSquareNumbersTest {
    SumOfSquareNumbers sumOfSquareNumbers;

    @Test
    void testExample1() {
        assertTrue(sumOfSquareNumbers.judgeSquareSum(5));
    }

    @Test
    void testExample2() {
        assertFalse(sumOfSquareNumbers.judgeSquareSum(3));
    }

    @Test
    void testExample3() {
        assertTrue(sumOfSquareNumbers.judgeSquareSum(4));
    }

    @Test
    void testExample4() {
        assertTrue(sumOfSquareNumbers.judgeSquareSum(2));
    }

    @Test
    void testExample5() {
        assertTrue(sumOfSquareNumbers.judgeSquareSum(1));
    }

    @Test
    void testMaxInt() {
        sumOfSquareNumbers.judgeSquareSum(Integer.MAX_VALUE);
    }
}
