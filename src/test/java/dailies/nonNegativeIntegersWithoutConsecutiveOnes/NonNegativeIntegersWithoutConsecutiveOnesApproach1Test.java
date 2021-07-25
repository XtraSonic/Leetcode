package dailies.nonNegativeIntegersWithoutConsecutiveOnes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonNegativeIntegersWithoutConsecutiveOnesApproach1Test extends NonNegativeIntegersWithoutConsecutiveOnesTest {

    NonNegativeIntegersWithoutConsecutiveOnesApproach1 nniwcoa1;

    @BeforeEach
    void setup() {
        nniwcoa1 = new NonNegativeIntegersWithoutConsecutiveOnesApproach1();
        nniwco = nniwcoa1;
    }

    @Test
    void testGetNumberOfIntegersWithConsecutiveOnesWithLength() {
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(0));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(1));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(2));
        assertEquals(3, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(3));
        assertEquals(8, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(4));
        assertEquals(19, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes(5));
    }


    @Test
    void testGetNumberOfIntegersWithConsecutiveOnesWithBinary() {
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("0"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11"));

        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("100"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("101"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("110"));
        assertEquals(2, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("111"));

        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1000"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1001"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1010"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1011"));
        assertEquals(2, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1100"));
        assertEquals(3, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1101"));
        assertEquals(4, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1110"));
        assertEquals(5, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("1111"));

        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10000"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10001"));
        assertEquals(0, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10010"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10011"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10100"));
        assertEquals(1, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10101"));
        assertEquals(2, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10110"));
        assertEquals(3, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("10111"));
        assertEquals(4, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11000"));
        assertEquals(5, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11001"));
        assertEquals(6, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11010"));
        assertEquals(7, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11011"));
        assertEquals(8, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11100"));
        assertEquals(9, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11101"));
        assertEquals(10, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11110"));
        assertEquals(11, nniwcoa1.getNumberOfIntegersWithConsecutiveOnes("11111"));
    }
}
